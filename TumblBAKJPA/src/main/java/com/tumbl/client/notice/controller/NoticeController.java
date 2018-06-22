/*package com.tumbl.client.notice.controller;

import java.util.List;

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
@RequestMapping(value = "/member")
public class NoticeController {
	Logger logger = Logger.getLogger(NoticeController.class);

	@Autowired
	private AdminNoticeService adminNoticeService;

	*//**************************************************************
	 * �۸�� �����ϱ�
	 **************************************************************//*
	@RequestMapping(value = "/noticeList.do", method = RequestMethod.GET)
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
		return "notice/noticeList";
	}


	*//**************************************************************
	 * �� �󼼺��� ����
	 **************************************************************//*
	@RequestMapping(value = "/noticeDetail.do", method = RequestMethod.GET)
	public String noticeDetail(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("noticeDetail ȣ�� ����");
		logger.info("n_no = " + nvo.getN_no());
		NoticeVO detail = new NoticeVO();
		detail = adminNoticeService.noticeDetail(nvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setN_content(detail.getN_content().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "notice/noticeDetail";
	}

	
}
*/