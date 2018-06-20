/*package com.tumbl.client.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.client.login.vo.LoginVO;
import com.tumbl.client.member.service.MemberService;
import com.tumbl.client.member.vo.MemberVO;
import com.tumbl.client.qna.service.QnaService;
import com.tumbl.client.qna.vo.QnaVO;
import com.tumbl.common.file.FileUploadUtil;
import com.tumbl.common.page.Paging;
import com.tumbl.common.util.Util;

@Controller
@RequestMapping(value = "/qna")
public class QnaController {
	Logger logger = Logger.getLogger(QnaController.class);

	@Autowired
	private QnaService qnaService;

	*//**************************************************************
	 * �۸�� �����ϱ�
	 **************************************************************//*
	@RequestMapping(value = "/qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(@ModelAttribute QnaVO qvo, Model model, HttpSession session) {
		logger.info("qnaList ȣ�� ����");

		// ������ ����
		Paging.setPage(qvo);
		// ��ü ���ڵ�� ����
		int total = qnaService.qnaListCnt(qvo);
		logger.info("total = " + total);
		ModelAndView mav = new ModelAndView();
		// �۹�ȣ �缳��
		int count = total - (Util.nvl(qvo.getPage()) - 1) * Util.nvl(qvo.getPageSize());
		logger.info("count = " + count);

		List<QnaVO> qnaList = qnaService.qnaList(qvo);

		model.addAttribute("qnaList", qnaList);
		model.addAttribute("count", count);
		model.addAttribute("total", total);
		model.addAttribute("data", qvo);
		mav.setViewName("qna/qnaList");
		return mav;
	}

	*//**************************************************************
	 * �� �󼼺��� ����
	 **************************************************************//*
	@RequestMapping(value = "/qnaDetail.do", method = RequestMethod.GET)
	public String qnaDetail(@ModelAttribute QnaVO pvo, Model model) {
		logger.info("qnaDetail ȣ�� ����");
		logger.info("b_num = " + pvo.getQ_num());
		QnaVO detail = new QnaVO();
		detail = qnaService.qnaDetail(pvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setQ_content(detail.getQ_content().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "qna/qnaDetail";
	}

	*//**************************************************************
	 * ��й�ȣ Ȯ��
	 * 
	 * @param b_num
	 * @param b_pwd
	 * @return int�� result�� 0 �Ǵ� 1�� ������ ���� �ְ�, String�� result ���� "���� or ����"�� ������ ����
	 *         �ִ�.(���� ���ڿ� ����) ���� : @ResponseBody�� ���޵� �並 ���ؼ� ����ϴ� ���� �ƴ϶� HTTP
	 *         Response Body�� ���� ����ϴ� ���. produces �Ӽ��� ������ �̵�� Ÿ�԰� ���õ� ������ �����ϴµ� �����
	 *         ���� ����Ʈ Ÿ���� ����.
	 **************************************************************//*
	@ResponseBody
	@RequestMapping(value = "/pwdConfirm.do", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public String pwdConfirm(@ModelAttribute QnaVO qvo) {
		logger.info("pwdConfirm ȣ�� ����");
		String value = "";
		// �Ʒ� �������� �Է� ������ ���� ���°� ����(1 or 0)
		int result = qnaService.pwdConfirm(qvo);
		if (result == 1) {
			value = "����";
		} else {
			value = "����";
		}
		logger.info("result = " + result);
		return value + "";
	}

	*//**************************************************************
	 * �ۼ��� �� ����ϱ�
	 * 
	 * @param :
	 *            b_num
	 * @return : QnaVO
	 **************************************************************//*
	@RequestMapping(value = "/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute QnaVO qvo, Model model) {
		logger.info("updateForm ȣ�� ����");
		logger.info("b_num = " + qvo.getQ_num());
		QnaVO updateData = new QnaVO();
		
		updateData = qnaService.qnaDetail(qvo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", qvo);
		return "qna/updateForm";
	}

	*//**************************************************************
	 * �ۼ��� �����ϱ�
	 * 
	 * @param :
	 *            QnaVO
	 **************************************************************//*
	@RequestMapping(value = "/qnaUpdate.do", method = RequestMethod.POST)
	public String qnaUpdate(@ModelAttribute QnaVO qvo, HttpServletRequest request) throws IllegalStateException, IOException {
		logger.info("qnaUpdate ȣ�� ����");
		int result = 0;
		String url = "";
		String b_file="";
		System.out.println("Ÿ���� ������ư");
		
		if(!qvo.getFile().isEmpty()) {
			logger.info("======== file = " +qvo.getFile().getOriginalFilename());
			if(!qvo.getB_file().isEmpty()) {
				FileUploadUtil.fileDelete(qvo.getB_file(), request);
			}
			b_file = FileUploadUtil.fileUpload(qvo.getFile(), request, "qna");
			qvo.setB_file(b_file);
		}else {
			logger.info("÷������ ����");
			qvo.setB_file("");
		}
		System.out.println(qvo.getQ_content());
		result = qnaService.qnaUpdate(qvo);
		if (result == 1) {
			// url="/qna/qnaList.do"; // ���� �� ������� �̵�
			// �Ʒ� url�� ���� �� �� �������� �̵�
			url = "/qna/qnaDetail.do?q_num=" + qvo.getQ_num();
		} else {
			url = "/qna/updateForm.do??q_num=" + qvo.getQ_num();
		}
		return "redirect:" + url;
	}

	*//**************************************************************
	 * �ۻ��� �����ϱ�
	 * 
	 * @throws IOException
	 **************************************************************//*
	@RequestMapping(value = "/qnaDelete.do", method = RequestMethod.GET)
	public String qnaDelete(@ModelAttribute QnaVO qvo, HttpServletRequest request) throws IOException {
		logger.info("qnaDelete ȣ�� ����");
		// �Ʒ� �������� �Է� ������ ���� ���°� ����ϴ�.(1 or 0)
		int result = 0;
		String url = "";
		
		if(!qvo.getB_file().isEmpty()) {
			FileUploadUtil.fileDelete(qvo.getB_file(), request);
		}
		
		result = qnaService.qnaDelete(qvo.getQ_num());
		if (result == 1) {
			url = "/qna/qnaList.do";
		} else {
			url = "/qna/qnaDetail.do?q_num=" + qvo.getQ_num();
		}
		return "redirect:" + url;
	}
}
*/