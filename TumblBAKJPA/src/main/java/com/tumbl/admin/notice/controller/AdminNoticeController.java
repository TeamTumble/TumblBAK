/*package com.tumbl.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumbl.admin.common.page.Paging;
import com.tumbl.admin.common.util.Util;
import com.tumbl.admin.notice.service.AdminNoticeService;
import com.tumbl.admin.notice.vo.NoticeVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminNoticeController {
	Logger logger = Logger.getLogger(AdminNoticeController.class);

	@Autowired
	private AdminNoticeService adminNoticeService;

	*//**************************************************************
	 * �۸�� �����ϱ�
	 **************************************************************//*
	@RequestMapping(value = "/notice/noticeList.do", method = RequestMethod.GET)
	public String noticeList(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("/notice/noticeList ȣ�� ����");

		// ������ ����
		Paging.setPage(nvo);
		// ��ü ���ڵ�� ����
		int total = adminNoticeService.noticeListCnt(nvo);
		logger.info("total = " + total);

		// �۹�ȣ �缳��
		int count = total - (Util.nvl(nvo.getPage()) - 1) * Util.nvl(nvo.getPageSize());
		logger.info("count = " + count);

		List<NoticeVO> noticeList = adminNoticeService.noticeList(nvo);

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("count", count);
		model.addAttribute("total", total);
		model.addAttribute("data", nvo);
		return "admin/notice/noticeList";
	}

	*//**************************************************************
	 * �۾��� �� ����ϱ�
	 **************************************************************//*
	@RequestMapping(value = "/notice/writeForm.do")
	public String writeForm() {
		logger.info("writeForm ȣ�� ����");
		return "admin/notice/writeForm";	
	}

	*//**************************************************************
	 * �۾��� �����ϱ�
	 **************************************************************//*
	@RequestMapping(value = "/notice/noticeInsert.do", method = RequestMethod.POST)
	public String noticeInsert(@ModelAttribute NoticeVO nvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("noticeInsert ȣ�� ����");
		int result = 0;
		String url = "";

		result = adminNoticeService.noticeInsert(nvo);
		if (result == 1) {
			url = "/admin/notice/noticeList.do";
		} else {
			model.addAttribute("code", 1);
			url = "/admin/notice/writeForm.do";
		}
		return "redirect:" + url;
	}

	*//**************************************************************
	 * �� �󼼺��� ����
	 **************************************************************//*
	@RequestMapping(value = "/notice/noticeDetail.do", method = RequestMethod.GET)
	public String noticeDetail(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("noticeDetail ȣ�� ����");
		logger.info("n_no = " + nvo.getN_no());
		NoticeVO detail = new NoticeVO();
		detail = adminNoticeService.noticeDetail(nvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setN_content(detail.getN_content().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "admin/notice/noticeDetail";
	}

	*//**************************************************************
	 * ��й�ȣ Ȯ��
	 * 
	 * @param n_no
	 * @param n_pwd
	 * @return int�� result�� 0 �Ǵ� 1�� ������ ���� �ְ�, String�� result ���� "���� or ����"�� ������ ����
	 *         �ִ�.(���� ���ڿ� ����) ���� : @ResponseBody�� ���޵� �並 ���ؼ� ����ϴ� ���� �ƴ϶� HTTP
	 *         Response Body�� ���� ����ϴ� ���. produces �Ӽ��� ������ �̵�� Ÿ�԰� ���õ� ������ �����ϴµ� �����
	 *         ���� ����Ʈ Ÿ���� ����.
	 **************************************************************//*

	*//**************************************************************
	 * �ۼ��� �� ����ϱ�
	 * 
	 * @param :
	 *            n_no
	 * @return : NoticeVO
	 **************************************************************//*
	@RequestMapping(value = "/notice/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("updateForm ȣ�� ����");
		logger.info("n_no = " + nvo.getN_no());
		NoticeVO updateData = new NoticeVO();

		updateData = adminNoticeService.noticeDetail(nvo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", nvo);
		return "admin/notice/updateForm";
	}

	*//**************************************************************
	 * �ۼ��� �����ϱ�
	 * 
	 * @param :
	 *            NoticeVO
	 **************************************************************//*
	@RequestMapping(value = "/notice/noticeUpdate.do", method = RequestMethod.POST)
	public String noticeUpdate(@ModelAttribute NoticeVO nvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("noticeUpdate ȣ�� ����");
		int result = 0;
		String url = "";

		result = adminNoticeService.noticeUpdate(nvo);
		if (result == 1) {
			// url="/notice/noticeList.do"; // ���� �� ������� �̵�
			// �Ʒ� url�� ���� �� �� �������� �̵�
			url = "/admin/notice/noticeDetail.do?n_no=" + nvo.getN_no();
		} else {
			url = "/admin/notice/updateForm.do??n_no=" + nvo.getN_no();
		}
		return "redirect:" + url;
	}

	*//**************************************************************
	 * �ۻ��� �����ϱ�
	 * 
	 * @throws IOException
	 **************************************************************//*
	@RequestMapping(value = "/notice/noticeDelete.do")
	public String noticeDelete(@ModelAttribute NoticeVO nvo, HttpServletRequest request) throws IOException {
		logger.info("noticeDelete ȣ�� ����");
		// �Ʒ� �������� �Է� ������ ���� ���°� ����ϴ�.(1 or 0)
		int result = 0;

		result = adminNoticeService.noticeDelete(nvo.getN_no());
		
		return "redirect:" + "/admin/notice/noticeList.do";
	}
}
*/