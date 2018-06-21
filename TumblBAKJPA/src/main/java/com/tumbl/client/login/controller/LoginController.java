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
	 * �α��� ȭ�� �����ֱ� ���� �޼���
	 **********************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("login.do get ȣ�� ����");

		return "member/login";
	}

	/**********************************
	 * �α��� ó�� �޼��� ���� : �α��� ���н� ó�� ���� ����.
	 **********************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute("Login") com.tumbl.client.login.vo.Login lvo, HttpSession session,
			HttpServletRequest request)  {
		logger.info("login.do post ȣ�⼺��");

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
	 * �α׾ƿ� ó�� �޼���
	 **************************************************************/
	@RequestMapping("/logout.do")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		session = request.getSession(true);
		return "redirect:/member/login.do";
	}
}