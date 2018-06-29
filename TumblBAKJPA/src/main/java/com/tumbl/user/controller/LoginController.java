package com.tumbl.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.user.service.LoginService;
import com.tumbl.user.service.MemberService;
import com.tumbl.user.vo.Login;

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
	 * 
	 * @throws IOException
	 * 
	 **********************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute("Login") com.tumbl.user.vo.Login lvo, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�α��� ���� .');</script>");
			out.flush();
			session.setAttribute("login", loginCheck);
			mav.setViewName("member/login");
			return mav;
		} catch (Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�Է��Ͻ� �̸��� �Ǵ� ��й�ȣ�� �ٸ��ϴ�.');</script>");
			out.flush();
			e.printStackTrace();
			mav.setViewName("member/login");
			return mav;
		}

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