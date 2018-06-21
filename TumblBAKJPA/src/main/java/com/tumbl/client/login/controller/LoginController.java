package com.tumbl.client.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.client.login.service.LoginService;
import com.tumbl.client.login.vo.Login;
import com.tumbl.client.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);

	@Resource
	private LoginService loginService;

	@Resource
	private MemberService memberService;

	/**********************************
	 * 로그인 화면 보여주기 위한 메서드
	 **********************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("login.do get 호출 성공");

		return "member/login";
	}

	/**********************************
	 * 로그인 처리 메서드 참고 : 로그인 실패시 처리 내용 포함.
	 **********************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute("Login") com.tumbl.client.login.vo.Login lvo, HttpSession session,
			HttpServletRequest request)  {
		logger.info("login.do post 호출성공");

		ModelAndView mav = new ModelAndView();
		String email = lvo.getEmail();
		System.out.println(lvo.getEmail() + "       " + lvo.getMpw());

		/*
		 * Login loginCheckResult =
		 * loginService.loginSelect(lvo.getEmail(),lvo.getMpw());
		 */
		try {
			Login loginCheck = loginService.loginSelect(lvo.getEmail(), lvo.getMpw());
			System.out.println(loginCheck);
			if (loginCheck == null) {
				mav.addObject("errCode", 1);
				mav.setViewName("member/login");
				return mav;
			} else {
				session.setAttribute("login", loginCheck);
				mav.setViewName("member/login");
				return mav;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		

		return mav;

	}

	/**************************************************************
	 * 로그아웃 처리 메서드
	 **************************************************************/
	@RequestMapping("/logout.do")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		session = request.getSession(true);
		return "redirect:/member/login.do";
	}
}