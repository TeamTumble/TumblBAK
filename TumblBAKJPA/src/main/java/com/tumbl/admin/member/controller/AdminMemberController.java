package com.tumbl.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumbl.admin.member.service.AdminMemberService;
import com.tumbl.client.common.page.Paging;
import com.tumbl.client.member.vo.Member;
import com.tumbl.common.util.Util;

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
	public String memberList(@ModelAttribute Member bvo, Model model, HttpServletRequest request, HttpSession session) {
		logger.info("memberList 호출 성공");

		
		
		// 페이지 세팅
		Paging.setPage(bvo);
		
		// view 단에 몇개씩 보일지 설정해야함. 06/20
		
		
/*		System.out.println("시작점 bvo" + bvo);
		*/
		
	/*	Login login = (Login) session.getAttribute("login");
		
		System.out.println("시작점 login"+ login);*/
		
	/*	bvo.setEmail(login.getEmail());*/
		// 글번호 재설정

		long total = adminMemberService.countadminMember(bvo);
		System.out.println(bvo.getPage() + "       " + bvo.getPageSize());
		long count = total - (Util.nvl(bvo.getPage()) - 1) * Util.nvl(bvo.getPageSize());
		PageRequest pageRequest = new PageRequest(Util.nvl(bvo.getPage()) - 1, Util.nvl(bvo.getPageSize()),
				new Sort(Direction.DESC, "idx"));
		Page<Member> page = adminMemberService.findAll(pageRequest);
		List<Member> cQvo = page.getContent();

		model.addAttribute("boardList", cQvo);
		model.addAttribute("test", page.getNumberOfElements());
		model.addAttribute("count", count);
		model.addAttribute("total", total);
		model.addAttribute("data", bvo);

		List<Member> memberList = adminMemberService.memberList(bvo);

		model.addAttribute("memberList", memberList);

		return "admin/member/memberList";
	}
}
