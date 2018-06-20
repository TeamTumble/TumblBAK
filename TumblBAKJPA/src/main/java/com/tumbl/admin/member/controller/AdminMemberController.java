package com.tumbl.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumbl.admin.member.service.AdminMemberService;
import com.tumbl.client.member.vo.Member;

@Controller
@RequestMapping(value = "/admin")
public class AdminMemberController {
	Logger logger = Logger.getLogger(AdminMemberController.class);

	@Autowired
	private AdminMemberService adminMemberService;

	/**************************************************************
	 * 회원 리스트 구현하기
	 **************************************************************/
	@RequestMapping(value = "/member/memberList.do", method = RequestMethod.GET)
	public String memberList(@ModelAttribute Member bvo, Model model, HttpServletRequest request) {
		logger.info("memberList 호출 성공");
		
		List<Member> memberList = adminMemberService.memberList(bvo);
		
		
		model.addAttribute("memberList", memberList);

		return "admin/member/memberList";
	}
}
