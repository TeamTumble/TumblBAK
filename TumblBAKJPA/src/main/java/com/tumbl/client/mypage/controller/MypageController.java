/*package com.tumbl.client.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumbl.client.login.controller.LoginController;

@Controller
@RequestMapping("/member")
public class MypageController {
	Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public String login(HttpSession session, HttpServletRequest request) {
		logger.info("login.do get 호출 성공");
		return "member/mypage";
	}
}
*/