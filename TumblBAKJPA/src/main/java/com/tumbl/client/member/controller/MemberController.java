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
	 * ȸ�� ���� ��
	 **************************************************************/
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("join.do get ��Ŀ� ���� �޼��� ȣ�� ����");
		return "member/join";
	}

	/**************************************************************
	 * ȸ�� ���� ó��
	 **************************************************************/
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public ModelAndView memberInsert(Member mvo) {

		logger.info("join.do post ��Ŀ� ���� �޼��� ȣ�� ����");
		ModelAndView mav = new ModelAndView();
		System.out.println("��Ʈ�ѷ�   " + mvo);

		memberService.join(mvo);

		mav.addObject("errCode", 3);
		mav.setViewName("member/join_success");

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/userIdConfirm.do", method = RequestMethod.POST)
	public String userIdConfirm(@RequestParam String email) {
		int result = memberService.userIdConfirm(email);
		return result + "";
	}


	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public ModelAndView memberModify(HttpSession session) {
		logger.info("modify.do get ��Ŀ� ���� �޼��� ȣ�� ����");
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
		// ȸ������ ����
		ModelAndView mav = new ModelAndView();
		// �α��� ���ǰ��� �����´�
		Login login = (Login) session.getAttribute("login");
		if (login == null) {
			mav.setViewName("member/login");
			return mav;
		}
		// �α��� ���ǿ� �ִ� �̸����� ������ ���VO�� �־��ش�
		mvo.setEmail(login.getEmail());
		// ���VO�ȿ� �� �̸����� ���� ����� ����Ư�ؿ´�
		Member vo = memberService.findByemail(mvo.getEmail());
		System.out.println("���� ��Ʈ�ѷ� MVO =======  " + mvo);
		System.out.println("���� ��Ʈ�ѷ� VO =======  " + vo);
		memberService.findByEmailAndMpw(mvo.getEmail(), mvo.getOldm_pw());

		memberService.memberUpdate(mvo);
		mav.setViewName("redirect:/member/logout.do");
		return mav;

	}

	@RequestMapping("/delete.do")
	public ModelAndView memberDelete(HttpSession session) {
		logger.info("delete.do get��Ŀ� ���� �޼��� ȣ�� ����");
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

	// �� �Ŀ���Ȳ
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
