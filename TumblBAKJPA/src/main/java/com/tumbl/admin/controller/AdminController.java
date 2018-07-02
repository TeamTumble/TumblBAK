package com.tumbl.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumbl.admin.common.util.Util;
import com.tumbl.admin.service.AdminMemberService;
import com.tumbl.admin.service.AdminSupportService;
import com.tumbl.user.service.ProjectService;
import com.tumbl.user.vo.Member;
import com.tumbl.user.vo.ProjectVO;
import com.tumbl.user.vo.SupportVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Resource
	private ProjectService projectService;
	@Resource
	private AdminSupportService adminSupportService;
	@Resource
	private AdminMemberService adminMemberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(@ModelAttribute ProjectVO pvo, SupportVO svo, Member mvo, Model model, HttpSession session) {
		PageRequest newProject = new PageRequest(0, 3, new Sort(Direction.DESC, "pno"));
		Page<ProjectVO> projectList_New = projectService.projectList_New("½ÂÀÎ", newProject);
		List<ProjectVO> newpro = projectList_New.getContent();
		model.addAttribute("projectList", newpro);

		PageRequest waitProject = new PageRequest(0, 3, new Sort(Direction.DESC, "pno"));
		Page<ProjectVO> projectList_Wait = projectService.projectList_New("½ÂÀÎ´ë±â", waitProject);
		List<ProjectVO> waitpro = projectList_Wait.getContent();
		model.addAttribute("projectList_wait", waitpro);

		PageRequest pageRequest = new PageRequest(0, 3, new Sort(Direction.DESC, "sno"));
		Page<SupportVO> page = adminSupportService.findAll(pageRequest);
		List<SupportVO> sQvo = page.getContent();
		model.addAttribute("supportList", sQvo);

		PageRequest member = new PageRequest(0, 5, new Sort(Direction.DESC, "idx"));
		Page<Member> membertotal = adminMemberService.findAll(member);
		List<Member> mQvo = membertotal.getContent();
		model.addAttribute("memberList", mQvo);
		return "basic";
	}
}
