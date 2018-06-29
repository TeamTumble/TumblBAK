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
	 * 로그인 화면 보여주기 위한 메서드
	 **********************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("login.do get 호출 성공");

		return "member/login";
	}

	/**********************************
	 * 로그인 처리 메서드 참고 : 로그인 실패시 처리 내용 포함.
	 * 
	 * @throws IOException
	 * 
	 **********************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(@ModelAttribute("Login") com.tumbl.user.vo.Login lvo, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 성공 .');</script>");
			out.flush();
			session.setAttribute("login", loginCheck);
			mav.setViewName("member/login");
			return mav;
		} catch (Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('입력하신 이메일 또는 비밀번호가 다릅니다.');</script>");
			out.flush();
			e.printStackTrace();
			mav.setViewName("member/login");
			return mav;
		}

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