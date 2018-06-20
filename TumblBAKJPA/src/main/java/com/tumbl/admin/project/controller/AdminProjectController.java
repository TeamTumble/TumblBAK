/*package com.tumbl.admin.project.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tumbl.admin.common.page.Paging;
import com.tumbl.admin.common.util.Util;
import com.tumbl.admin.project.service.AdminProjectService;
import com.tumbl.client.project.vo.ProjectVO;

import src.service.MailService;

@Controller
@RequestMapping(value = "/admin")
public class AdminProjectController {
	Logger logger = Logger.getLogger(AdminProjectController.class);

	@Autowired
	private AdminProjectService adminProjectService;
	
	private MailService mailService;

	*//**************************************************************
	 * 글목록 구현하기
	 **************************************************************//*
	@RequestMapping(value = "/project/projectList.do", method = RequestMethod.GET)
	public String projectList(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("/project/projectList 호출 성공");

		// 페이지 세팅
		Paging.setPage(pvo);
		// 전체 레코드수 구현
		int total = adminProjectService.projectListCnt(pvo);
		logger.info("total = " + total);

		// 글번호 재설정
		int count = total - (Util.nvl(pvo.getPage()) - 1) * Util.nvl(pvo.getPageSize());
		logger.info("count = " + count);

		List<ProjectVO> projectList = adminProjectService.projectList(pvo);

		model.addAttribute("projectList", projectList);
		model.addAttribute("count", count);
		model.addAttribute("total", total);
		model.addAttribute("data", pvo);
		return "admin/project/projectList";
	}

	*//**************************************************************
	 * 글 상세보기 구현
	 **************************************************************//*
	@RequestMapping(value = "/project/projectDetail.do", method = RequestMethod.GET)
	public String projectDetail(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectDetail 호출 성공");
		logger.info("p_no = " + pvo.getPno());
		ProjectVO detail = new ProjectVO();
		detail = adminProjectService.projectDetail(pvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setP_title(detail.getP_title().toString().replaceAll("\n", "<br>"));
		}
		System.out.println(detail.getPno());
		model.addAttribute("detail", detail);
		return "admin/project/projectDetail";
	}

	*//**************************************************************
	 * 글 상세보기 구현 (저장하기 버튼 클릭시)
	 **************************************************************//*
	@RequestMapping(value = "/project/projectDetail.do", method = RequestMethod.POST)
	public String projectDetailSave(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectDetail 호출 성공");
		logger.info("p_no = " + pvo.getPno());

		adminProjectService.projectUpdate(pvo);// 업데이트해준
		ProjectVO detail = new ProjectVO();// 후에 다시 디테일(projectVO)정보를 가져와서
		detail = adminProjectService.projectDetail(pvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setP_title(detail.getP_title().toString().replaceAll("\n", "<br>"));
		}
		
		model.addAttribute("detail", detail);// jsp로 보내준다
		return "admin/project/projectDetail";
	}

	*//**************************************************************
	 * 메일보내기
	 **************************************************************//*
	@ResponseBody
	@RequestMapping(value = "/project/projectMail.do", method = RequestMethod.POST, produces = "application/json")
	private boolean sendMail(@RequestParam String pm_email, @RequestParam String p_remarks,
			@RequestParam String p_case, @RequestParam String p_no) {
		//프로젝트 검사 저장하기
		ProjectVO pvo = new ProjectVO();
		pvo.setPno(Integer.parseInt(p_no));
		pvo.setP_remarks(p_remarks);
		pvo.setP_case(p_case);
		adminProjectService.projectUpdate(pvo);
		
		
		//프로젝트 이메일 보내기
		String subject = "BumbleBug 프로젝트 검사 결과입니다.";
		StringBuilder sb = new StringBuilder();
		
		if(p_case.equals("승인")) {
			sb.append("프로젝트가 승인되었습니다.");
			return mailService.send(subject, sb.toString(), "dmsrl268@gmail.com", pm_email);
		}else {
			sb.append("승인여부 : ").append(p_case).append("\n검사내용 : ").append(p_remarks);
			return mailService.send(subject, sb.toString(), "dmsrl268@gmail.com", pm_email);
		}
	}

	*//**************************************************************
	 * 글수정 구현하기
	 * 
	 * @param :
	 *            ProjectVO
	 **************************************************************//*
	@RequestMapping(value = "/project/mailService.do", method = RequestMethod.POST)
	public String mailService(@ModelAttribute ProjectVO pvo, Model model) throws IllegalStateException, IOException {
		logger.info("mailSend 호출 성공");
		logger.info("p_no = " + pvo.getPno());
		ProjectVO detail = new ProjectVO();
		detail = adminProjectService.MailService(pvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setP_story(detail.getP_story().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "admin/project/mailService";
	}

	*//**************************************************************
	 * 프로젝트 링크
	 * 
	 * @param :
	 *            ProjectVO
	 **************************************************************//*
	@RequestMapping(value = "/project/projectLink.do", method = RequestMethod.POST)
	public String projectLink(@ModelAttribute ProjectVO pvo, Model model) throws IllegalStateException, IOException {
		logger.info("projectLink 호출 성공");
		logger.info("p_no = " + pvo.getPno());
		ProjectVO detail = new ProjectVO();
		detail = adminProjectService.projectLink(pvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setP_story(detail.getP_story().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "project/projectDetail";
	}

	*//**************************************************************
	 * 글수정 폼 출력하기
	 * 
	 * @param :
	 *            p_no
	 * @return : ProjectVO
	 **************************************************************//*
	@RequestMapping(value = "/project/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("updateForm 호출 성공");
		logger.info("p_no = " + pvo.getPno());
		ProjectVO updateData = new ProjectVO();

		updateData = adminProjectService.projectDetail(pvo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", pvo);
		return "admin/project/updateForm";
	}
}*/