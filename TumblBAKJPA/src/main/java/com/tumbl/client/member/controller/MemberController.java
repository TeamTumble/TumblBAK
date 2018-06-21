package com.tumbl.client.member.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.client.login.vo.Login;
import com.tumbl.client.member.service.MemberService;
import com.tumbl.client.member.vo.Member;
import com.tumbl.client.project.vo.ProjectVO;
import com.tumbl.client.support.vo.SupportVO;

/*import src.service.MailService;*/

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	Logger logger = Logger.getLogger(MemberController.class);

	@Resource
	MemberService memberService;
	/*
	 * @Autowired private MemberService memberService;
	 */

	/*
	 * @Autowired private MailService mailService;
	 */

	/*
	 * @Autowired private LoginService loginService;
	 */

	/**************************************************************
	 * 회원 가입 폼
	 **************************************************************/
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("join.do get 방식에 의한 메서드 호출 성공");
		return "member/join";
	}

	/**************************************************************
	 * 회원 가입 처리
	 **************************************************************/
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public ModelAndView memberInsert(Member mvo) {

		logger.info("join.do post 방식에 의한 메서드 호출 성공");
		ModelAndView mav = new ModelAndView();
		System.out.println("컨트롤러   " + mvo);

		memberService.join(mvo);

		mav.addObject("errCode", 3);
		mav.setViewName("member/join_success");

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/userIdConfirm.do", method = RequestMethod.POST)
	public String userIdConfirm(@RequestParam String email) {
		System.out.println("여기까지 온다 아이디");
		memberService.findOne(email);
		return email;
	}

	/*
	 * //인증메일 보내는 메소드
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/mail.do", method = RequestMethod.POST, produces =
	 * "application/json" ) private boolean sendMail(HttpSession
	 * session, @RequestParam String email) { //인증번호 랜덤코드 int randomCode = new
	 * Random().nextInt(10000) + 1000; String joinCode = String.valueOf(randomCode);
	 * session.setAttribute("joinCode", joinCode);
	 * 
	 * String subject = "회원가입 승인 번호 입니다."; StringBuilder sb = new StringBuilder();
	 * sb.append("회원가입 승인번호는 ").append(joinCode).append(" 입니다.");
	 * System.out.println(joinCode); return mailService.send(subject, sb.toString(),
	 * "poiuripjava@gmail.com", email); }
	 */

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/check.do", method = RequestMethod.POST, produces =
	 * "application/json" ) public int check(HttpSession session, @RequestParam
	 * String inputCode ) { int result; String code =
	 * (String)session.getAttribute("joinCode");
	 * 
	 * 
	 * if(code.equals(inputCode)) { result = 1; } else { result = 2; } return
	 * result; }
	 */

	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public ModelAndView memberModify(HttpSession session) {
		logger.info("modify.do get 방식에 의한 메서드 호출 성공");
		ModelAndView mav = new ModelAndView();
		Login login = (Login) session.getAttribute("login");
		if (login == null) {
			mav.setViewName("member/login");
			return mav;
		}
		Member vo = memberService.findByemail(login.getEmail());
		mav.addObject("member", vo);
		mav.setViewName("member/modify");
		return mav;
	}

	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public ModelAndView memberModifyProcess(@ModelAttribute("Member") Member mvo, HttpSession session) {
		// 회원정보 수정
		ModelAndView mav = new ModelAndView();
		// 로그인 세션값을 가져온다
		Login login = (Login) session.getAttribute("login");
		if (login == null) {
			mav.setViewName("member/login");
			return mav;
		}
		// 로그인 세션에 있는 이메일을 가져와 멤버VO에 넣어준다
		mvo.setEmail(login.getEmail());
		// 멤버VO안에 들어가 이메일을 통해 멤버를 셀레특해온다
		Member vo = memberService.findByemail(mvo.getEmail());
		System.out.println("수정 컨트롤러 MVO =======  " + mvo);
		System.out.println("수정 컨트롤러 VO =======  " + vo);
		memberService.findByEmailAndMpw(mvo.getEmail(), mvo.getOldm_pw());

		memberService.memberUpdate(mvo);
		mav.setViewName("redirect:/member/logout.do");
		return mav;

	}

	@RequestMapping("/delete.do")
	public ModelAndView memberDelete(HttpSession session) {
		logger.info("delete.do get방식에 의한 메서드 호출 성공");
		ModelAndView mav = new ModelAndView();
		Login login = (Login) session.getAttribute("login");
		if (login == null) {
			mav.setViewName("member/login");
			return mav;
		}
		memberService.memberDelete(login.getEmail());

		mav.setViewName("redirect:/member/logout.do");

		return mav;
	}

	@RequestMapping(value = "/projectMember.do", method = RequestMethod.GET)
	public String projectCreate(ProjectVO pvo, Model model, HttpSession session) {
		logger.info("projectCreate ");
		ModelAndView mav = new ModelAndView();
		Login login = (Login) session.getAttribute("login");
		if (login == null) {

			return "member/login";
		}

		pvo.setEmail(login.getEmail());
		System.out.println(pvo.getEmail());
		List<ProjectVO> projectList = memberService.projectMember(pvo);
		System.out.println(projectList);
		model.addAttribute("projectList", projectList);
		model.addAttribute("data", pvo);
		model.addAttribute("num", pvo.getPno());
		model.addAttribute("login", login);

		return "member/projectMember";
	}

	// 내 후원현황
	@RequestMapping(value = "/supportMember.do", method = RequestMethod.GET)
	public String projectCreate(SupportVO svo, Model model, HttpSession session) {
		logger.info("projectCreate ");
		Login login = (Login) session.getAttribute("login");
		if (login == null) {
			return "member/login";
		}
		svo.setEmail(login.getEmail());
		System.out.println(svo.getEmail());
		List<SupportVO> projectList = memberService.supportMember(svo);
		System.out.println(projectList);
		model.addAttribute("projectList", projectList);
		model.addAttribute("data", svo);
		model.addAttribute("num", svo.getPno());
		model.addAttribute("login", login);

		return "member/supportMember";
	}

}
