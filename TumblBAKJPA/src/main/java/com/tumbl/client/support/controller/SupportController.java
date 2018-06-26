package com.tumbl.client.support.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.client.login.vo.Login;
import com.tumbl.client.project.vo.ProjectVO;
import com.tumbl.client.support.service.SupportService;
import com.tumbl.client.support.vo.SupportVO;

@Controller
@RequestMapping(value = "/support")
public class SupportController {
	Logger logger = Logger.getLogger(SupportController.class);

	@Resource
	private SupportService supportService;

	/**************************************************************
	 **************************************************************/
	@RequestMapping(value = "/supportCreate.do", method = RequestMethod.GET)
	public ModelAndView support(@ModelAttribute SupportVO svo, Model model, HttpSession session) {
		logger.info("supportCreate 출력");

		SupportVO detail = new SupportVO();
		ModelAndView mav = new ModelAndView();

		Login login = (Login) session.getAttribute("login");

		if (login == null) {
			mav.setViewName("member/login");
			return mav;
		}
		svo.setEmail(login.getEmail());
		detail = supportService.supportDetail(svo);
		model.addAttribute("detail", detail);
		model.addAttribute("data", svo);
		mav.addObject("detail", detail);
		mav.addObject("data", svo);
		mav.setViewName("support/supportCreate");

		return mav;
	}

	/*
	 * //**************************************************************
	 **************************************************************/
	@RequestMapping(value = "/supportInsert.do", method = RequestMethod.POST)
	public ModelAndView supportInsert(@ModelAttribute("SupportVO") SupportVO svo, Model model, HttpServletRequest request,
			HttpSession session) {
		logger.info("supportInsert 호출 성공");

		SupportVO result = new SupportVO();
		ModelAndView mav = new ModelAndView();
		Date todate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		String dTime = formatter.format(todate);
		String url = "";
		svo.setS_date(dTime);
		result = supportService.supportInsert(svo);
		supportService.supportInsertPlus(svo);
		mav.addObject("detail", result);
		mav.addObject("data", svo);
		mav.setViewName("support/support_success");
		return mav;
	}

	@RequestMapping(value = "/supportSuccess.do", method = RequestMethod.GET)
	public String supportSuccess(@ModelAttribute("SupportVO") SupportVO svo, Model model,HttpServletRequest request, HttpSession session) {
		System.out.println("컨트롤러 초반 svo =================  " +svo);

		SupportVO detail = new SupportVO();

		Login login = (Login) session.getAttribute("login");
		System.out.println(login.getEmail());
		svo.setEmail(login.getEmail());
		System.out.println(svo.getSno());

		detail = supportService.supportSuccess(svo);
		System.out.println("컨트롤러 svo ===============  " +detail);

		model.addAttribute("detail", detail);
		model.addAttribute("data", svo);
		

		return "support/support_success";
	}

}
