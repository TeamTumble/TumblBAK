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
	 * �۸�� �����ϱ�
	 **************************************************************//*
	@RequestMapping(value = "/project/projectList.do", method = RequestMethod.GET)
	public String projectList(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("/project/projectList ȣ�� ����");

		// ������ ����
		Paging.setPage(pvo);
		// ��ü ���ڵ�� ����
		int total = adminProjectService.projectListCnt(pvo);
		logger.info("total = " + total);

		// �۹�ȣ �缳��
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
	 * �� �󼼺��� ����
	 **************************************************************//*
	@RequestMapping(value = "/project/projectDetail.do", method = RequestMethod.GET)
	public String projectDetail(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectDetail ȣ�� ����");
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
	 * �� �󼼺��� ���� (�����ϱ� ��ư Ŭ����)
	 **************************************************************//*
	@RequestMapping(value = "/project/projectDetail.do", method = RequestMethod.POST)
	public String projectDetailSave(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectDetail ȣ�� ����");
		logger.info("p_no = " + pvo.getPno());

		adminProjectService.projectUpdate(pvo);// ������Ʈ����
		ProjectVO detail = new ProjectVO();// �Ŀ� �ٽ� ������(projectVO)������ �����ͼ�
		detail = adminProjectService.projectDetail(pvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setP_title(detail.getP_title().toString().replaceAll("\n", "<br>"));
		}
		
		model.addAttribute("detail", detail);// jsp�� �����ش�
		return "admin/project/projectDetail";
	}

	*//**************************************************************
	 * ���Ϻ�����
	 **************************************************************//*
	@ResponseBody
	@RequestMapping(value = "/project/projectMail.do", method = RequestMethod.POST, produces = "application/json")
	private boolean sendMail(@RequestParam String pm_email, @RequestParam String p_remarks,
			@RequestParam String p_case, @RequestParam String p_no) {
		//������Ʈ �˻� �����ϱ�
		ProjectVO pvo = new ProjectVO();
		pvo.setPno(Integer.parseInt(p_no));
		pvo.setP_remarks(p_remarks);
		pvo.setP_case(p_case);
		adminProjectService.projectUpdate(pvo);
		
		
		//������Ʈ �̸��� ������
		String subject = "BumbleBug ������Ʈ �˻� ����Դϴ�.";
		StringBuilder sb = new StringBuilder();
		
		if(p_case.equals("����")) {
			sb.append("������Ʈ�� ���εǾ����ϴ�.");
			return mailService.send(subject, sb.toString(), "dmsrl268@gmail.com", pm_email);
		}else {
			sb.append("���ο��� : ").append(p_case).append("\n�˻系�� : ").append(p_remarks);
			return mailService.send(subject, sb.toString(), "dmsrl268@gmail.com", pm_email);
		}
	}

	*//**************************************************************
	 * �ۼ��� �����ϱ�
	 * 
	 * @param :
	 *            ProjectVO
	 **************************************************************//*
	@RequestMapping(value = "/project/mailService.do", method = RequestMethod.POST)
	public String mailService(@ModelAttribute ProjectVO pvo, Model model) throws IllegalStateException, IOException {
		logger.info("mailSend ȣ�� ����");
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
	 * ������Ʈ ��ũ
	 * 
	 * @param :
	 *            ProjectVO
	 **************************************************************//*
	@RequestMapping(value = "/project/projectLink.do", method = RequestMethod.POST)
	public String projectLink(@ModelAttribute ProjectVO pvo, Model model) throws IllegalStateException, IOException {
		logger.info("projectLink ȣ�� ����");
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
	 * �ۼ��� �� ����ϱ�
	 * 
	 * @param :
	 *            p_no
	 * @return : ProjectVO
	 **************************************************************//*
	@RequestMapping(value = "/project/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("updateForm ȣ�� ����");
		logger.info("p_no = " + pvo.getPno());
		ProjectVO updateData = new ProjectVO();

		updateData = adminProjectService.projectDetail(pvo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", pvo);
		return "admin/project/updateForm";
	}
}*/