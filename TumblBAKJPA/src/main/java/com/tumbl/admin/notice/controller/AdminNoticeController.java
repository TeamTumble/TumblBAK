package com.tumbl.admin.notice.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumbl.admin.common.page.Paging;
import com.tumbl.admin.common.util.Util;
import com.tumbl.admin.notice.service.AdminNoticeService;
import com.tumbl.admin.notice.vo.NoticeVO;
import com.tumbl.client.member.vo.Member;

@Controller
@RequestMapping(value = "/admin")
public class AdminNoticeController {
	Logger logger = Logger.getLogger(AdminNoticeController.class);

	@Resource
	private AdminNoticeService adminNoticeService;

	/**************************************************************
	 * �۸�� �����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeList.do", method = RequestMethod.GET)
	public String noticeList(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("/notice/noticeList ȣ�� ����");

		// ������ ����
		Paging.setPage(nvo);

		if (nvo.getKeyword().equals("")) {
			long total = adminNoticeService.countNotice(nvo);
			System.out.println(nvo.getPage() + "       " + nvo.getPageSize());
			long count = total - (Util.nvl(nvo.getPage()) - 1) * Util.nvl(nvo.getPageSize());
			PageRequest pageRequest = new PageRequest(Util.nvl(nvo.getPage()) - 1, Util.nvl(nvo.getPageSize()),
					new Sort(Direction.DESC, "idx"));
			Page<NoticeVO> page = adminNoticeService.findAll(pageRequest);
			List<NoticeVO> nQvo = page.getContent();
			model.addAttribute("noticeList", nQvo);
			model.addAttribute("count", count);
			model.addAttribute("total", total);
			model.addAttribute("data", nvo);
			return "admin/notice/noticeList";
		} else {
			if (nvo.getSearch().equals("ntitle")) {
				long total = adminNoticeService.countNotice(nvo);
				long count = total - (Util.nvl(nvo.getPage()) - 1) * Util.nvl(nvo.getPageSize());
				PageRequest pageRequest = new PageRequest(Util.nvl(nvo.getPage()) - 1, Util.nvl(nvo.getPageSize()),
						new Sort(Direction.DESC, "ntitle"));
				System.out.println("�˻� ��Ʈ�ѷ�      ==============  " + nvo.getKeyword());
				System.out.println("ntitle �˻� ��Ʈ�ѷ�      ==============  ž�� Ȯ��");
				Page<NoticeVO> page = adminNoticeService.findByNtitleContaining(nvo.getKeyword(), pageRequest);
				List<NoticeVO> nQvo = page.getContent();
				model.addAttribute("noticeList", nQvo);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("data", nvo);
				return "admin/notice/noticeList";
			}
			return "admin//notice/noticeList";
		}
	}

	/**************************************************************
	 * �۾��� �� ����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/notice/writeForm.do")
	public String writeForm() {
		logger.info("writeForm ȣ�� ����");

		// �α��� ���� ���� �� ���� �߰�

		return "admin/notice/writeForm";
	}

	/**************************************************************
	 * �۾��� �����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeInsert.do", method = RequestMethod.POST)
	public String noticeInsert(@ModelAttribute NoticeVO nvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("noticeInsert ȣ�� ����");
		System.out.println("�� �� �� �� ��");
		NoticeVO result = new NoticeVO();
		String url = "";
		Date todate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		String dTime = formatter.format(todate);
		nvo.setNdate(dTime);

		result = adminNoticeService.noticeInsert(nvo);
		if (result != null) {
			url = "/admin/notice/noticeList.do";
		} else {
			model.addAttribute("code", 1);
			url = "/admin/notice/writeForm.do";
		}
		return "redirect:" + url;
	}

	/**************************************************************
	 * �� �󼼺��� ����
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeDetail.do", method = RequestMethod.GET)
	public String noticeDetail(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("noticeDetail ȣ�� ����");
		logger.info("nno = " + nvo.getNno());
		NoticeVO detail = new NoticeVO();
		detail = adminNoticeService.noticeDetail(nvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setNcontent(detail.getNcontent().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "admin/notice/noticeDetail";
	}

	/**************************************************************
	 * ��й�ȣ Ȯ��
	 * 
	 * @param n_no
	 * @param n_pwd
	 * @return int�� result�� 0 �Ǵ� 1�� ������ ���� �ְ�, String�� result ���� "���� or ����"�� ������ ����
	 *         �ִ�.(���� ���ڿ� ����) ���� : @ResponseBody�� ���޵� �並 ���ؼ� ����ϴ� ���� �ƴ϶� HTTP
	 *         Response Body�� ���� ����ϴ� ���. produces �Ӽ��� ������ �̵�� Ÿ�԰� ���õ� ������ �����ϴµ� �����
	 *         ���� ����Ʈ Ÿ���� ����.
	 **************************************************************/

	/**************************************************************
	 * �ۼ��� �� ����ϱ�
	 * 
	 * @param :
	 *            n_no
	 * @return : NoticeVO
	 **************************************************************/
	@RequestMapping(value = "/notice/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("updateForm ȣ�� ����");
		logger.info("nno = " + nvo.getNno());
		NoticeVO updateData = new NoticeVO();

		updateData = adminNoticeService.noticeDetail(nvo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", nvo);
		return "admin/notice/updateForm";
	}

	/**************************************************************
	 * �ۼ��� �����ϱ�
	 * 
	 * @param :
	 *            NoticeVO
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeUpdate.do", method = RequestMethod.POST)
	public String noticeUpdate(@ModelAttribute NoticeVO nvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("noticeUpdate ȣ�� ����");
		int result = 0;
		String url = "";

		Date todate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		String dTime = formatter.format(todate);
		nvo.setNdate(dTime);

		adminNoticeService.noticeUpdate(nvo);
		if (result != 1) {
			// url="/notice/noticeList.do"; // ���� �� ������� �̵�
			// �Ʒ� url�� ���� �� �� �������� �̵�
			url = "/admin/notice/noticeDetail.do?nno=" + nvo.getNno();
		} else {
			url = "/admin/notice/updateForm.do?nno=" + nvo.getNno();
		}
		return "redirect:" + url;
	}

	/**************************************************************
	 * �ۻ��� �����ϱ�
	 * 
	 * @throws IOException
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeDelete.do")
	public String noticeDelete(@ModelAttribute NoticeVO nvo, HttpServletRequest request) throws IOException {
		logger.info("noticeDelete ȣ�� ����");

		adminNoticeService.noticeDelete(nvo.getNno());

		return "redirect:" + "/admin/notice/noticeList.do";
	}
}
