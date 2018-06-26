package com.tumbl.admin.login.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.admin.login.service.AdminLoginService;
import com.tumbl.admin.login.vo.AdminLoginVO;
import com.tumbl.client.login.vo.LoginVO;
import com.tumbl.client.member.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	Logger logger = Logger.getLogger(AdminLoginController.class);

	@Autowired
	private AdminLoginService adminloginService;
	
	/**********************************
	 * �α��� ȭ�� �����ֱ� ���� �޼���
	 **********************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(HttpSession session) {
		logger.info("login.do get ȣ�� ����");
		session.removeAttribute("login");
		return "admin/login/login";
	}

	/**************************************************************
	 * �α��� ó�� �޼��� ���� : �α��� ���н� ó�� ���� ����.
	 **************************************************************/
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute AdminLoginVO lvo, HttpSession session, HttpServletRequest request) {
		logger.info("login.do post ȣ�� ����");
		
		ModelAndView mav = new ModelAndView();
		AdminLoginVO resultData = adminloginService.AdminloginSelect(lvo.getAdid(), lvo.getAdpw());
		if (resultData == null) {
			mav.addObject("errCode", 1);
			mav.setViewName("redirect:/");
			return mav;
		} else {
			session.setAttribute("adminLogin", resultData);
			mav.setViewName("admin/member/memberList");
			return mav;
		}
	}

	/**************************************************************
	 * �α��� ó�� �޼��� ���� : �α��� ���н� ó�� ���� ����.
	 **************************************************************/
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute AdminLoginVO lvo, HttpSession session, HttpServletRequest request) {
		logger.info("login.do post ȣ�� ����");
		session.removeAttribute("adminLogin");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/login/login");
		return mav;
	}
}
