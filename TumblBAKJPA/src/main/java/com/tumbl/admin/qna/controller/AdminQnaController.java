package com.tumbl.admin.qna.controller;

import java.util.List;

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

import com.tumbl.admin.qna.service.AdminQnaService;
import com.tumbl.client.common.page.Paging;
import com.tumbl.client.qna.vo.QnaVO;
import com.tumbl.common.util.Util;

@Controller
@RequestMapping(value = "/admin")
public class AdminQnaController {
	Logger logger = Logger.getLogger(AdminQnaController.class);

	@Autowired
	private AdminQnaService adminQnaService;// qnaService

	/**************************************************************
	 * �۸�� �����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/qna/qnaList.do", method = RequestMethod.GET)
	public String qnaList(@ModelAttribute QnaVO qvo, Model model, HttpSession session) {
		logger.info("qnaList ȣ�� ����");

		// ������ ����
		Paging.setPage(qvo);
		// ��ü ���ڵ�� ����

		if (qvo.getKeyword().equals("")) {
			long total = adminQnaService.countAdminQna(qvo);
			System.out.println(qvo.getPage() + "       " + qvo.getPageSize());
			long count = total - (Util.nvl(qvo.getPage()) - 1) * Util.nvl(qvo.getPageSize());
			PageRequest pageRequest = new PageRequest(Util.nvl(qvo.getPage()) - 1, Util.nvl(qvo.getPageSize()),
					new Sort(Direction.DESC, "qnum"));
			Page<QnaVO> page = adminQnaService.findAll(pageRequest);
			List<QnaVO> cQvo = page.getContent();
			model.addAttribute("qnaList", cQvo);
			model.addAttribute("count", count);
			model.addAttribute("total", total);
			model.addAttribute("data", qvo);
			return "admin/qna/qnaList";
		} else {
			if (qvo.getSearch().equals("email")) {
				long total = adminQnaService.countAdminQna(qvo);
				long count = total - (Util.nvl(qvo.getPage()) - 1) * Util.nvl(qvo.getPageSize());
				PageRequest pageRequest = new PageRequest(Util.nvl(qvo.getPage()) - 1, Util.nvl(qvo.getPageSize()),
						new Sort(Direction.DESC, "email"));
				System.out.println("�˻� ��Ʈ�ѷ�      ==============  " + qvo.getKeyword());
				System.out.println("�̸��� �˻� ��Ʈ�ѷ�      ==============  ž�� Ȯ��");
				Page<QnaVO> page = adminQnaService.findByEmailContaining(qvo.getKeyword(), pageRequest);
				List<QnaVO> cQvo = page.getContent();
				model.addAttribute("qnaList", cQvo);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("data", qvo);
				return "admin/qna/qnaList";
			} else if (qvo.getSearch().equals("qtitle")) {
				long total = adminQnaService.countAdminQna(qvo);
				long count = total - (Util.nvl(qvo.getPage()) - 1) * Util.nvl(qvo.getPageSize());
				PageRequest pageRequest = new PageRequest(Util.nvl(qvo.getPage()) - 1, Util.nvl(qvo.getPageSize()),
						new Sort(Direction.DESC, "qtitle"));
				System.out.println("�˻� ��Ʈ�ѷ�      ==============  " + qvo.getKeyword());
				System.out.println("Ÿ��Ʋ �˻� ��Ʈ�ѷ�      ==============  ž�� Ȯ��");
				Page<QnaVO> page = adminQnaService.findByQtitleContaining(qvo.getKeyword(), pageRequest);
				List<QnaVO> cQvo = page.getContent();
				System.out.println("Ÿ��Ʋ �˻� ��Ʈ�ѷ�      ============== " + cQvo);
				model.addAttribute("qnaList", cQvo);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("data", qvo);
				return "admin/qna/qnaList";
			}
			return "admin/qna/qnaList";
		}
	}

	/**************************************************************
	 * �� �󼼺��� ����
	 **************************************************************/
	@RequestMapping(value = "/qna/qnaDetail.do", method = RequestMethod.GET)
	public String qnaDetail(@ModelAttribute QnaVO qvo, Model model) {
		logger.info("qnaDetail ȣ�� ����");
		logger.info("qnum = " + qvo.getQnum());
		QnaVO detail = new QnaVO();
		detail = adminQnaService.qnaDetail(qvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setQ_content(detail.getQ_content().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "admin/qna/qnaDetail";
	}
	/**************************************************************
	 * �۾��� �� ����ϱ�
	 **************************************************************/
	/*
	 * @RequestMapping(value = "/qna/writeForm.do") public String writeForm() {
	 * logger.info("writeForm ȣ�� ����"); return "admin/qna/writeForm"; }
	 */

	/**************************************************************
	 * �۾��� �����ϱ�
	 **************************************************************/
	/*
	 * @RequestMapping(value = "/qna/qnaInsert.do", method = RequestMethod.POST)
	 * public String qnaInsert(@ModelAttribute QnaVO qvo, Model model,
	 * HttpServletRequest request) throws IllegalStateException, IOException {
	 * logger.info("qnaInsert ȣ�� ����"); int result = 0; String url = "";
	 * 
	 * result = adminQnaService.qnaInsert(qvo); if (result == 1) { url =
	 * "/admin/qna/qnaList.do"; } else { model.addAttribute("code", 1); url =
	 * "/admin/qna/writeForm.do"; } return "redirect:" + url; }
	 */
	/**************************************************************
	 * ��й�ȣ Ȯ��
	 * 
	 * @param q_num
	 * @param q_pwd
	 * @return int�� result�� 0 �Ǵ� 1�� ������ ���� �ְ�, String�� result ���� "���� or ����"�� ������ ����
	 *         �ִ�.(���� ���ڿ� ����) ���� : @ResponseBody�� ���޵� �並 ���ؼ� ����ϴ� ���� �ƴ϶� HTTP
	 *         Response Body�� ���� ����ϴ� ���. produces �Ӽ��� ������ �̵�� Ÿ�԰� ���õ� ������ �����ϴµ� �����
	 *         ���� ����Ʈ Ÿ���� ����.
	 **************************************************************/
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/qna/pwdConfirm.do", method = RequestMethod.POST,
	 * produces = "text/plain; charset=UTF-8") public String
	 * pwdConfirm(@ModelAttribute QnaVO qvo) { logger.info("pwdConfirm ȣ�� ����");
	 * String value = ""; // �Ʒ� �������� �Է� ������ ���� ���°� ����(1 or 0) int result =
	 * adminQnaService.pwdConfirm(qvo); if (result == 1) { value = "����"; } else {
	 * value = "����"; } logger.info("result = " + result); return value + ""; }
	 * 
	 * /************************************************************** �ۼ��� �� ����ϱ�
	 * 
	 * @param : q_num
	 * 
	 * @return : QnaVO
	 **************************************************************//*
																	 * @RequestMapping(value = "/qna/updateForm.do",
																	 * method = RequestMethod.GET) public String
																	 * updateForm(@ModelAttribute QnaVO qvo, Model
																	 * model) { logger.info("updateForm ȣ�� ����");
																	 * logger.info("q_num = " + qvo.getQnum()); QnaVO
																	 * updateData = new QnaVO();
																	 * 
																	 * updateData = adminQnaService.qnaDetail(qvo);
																	 * model.addAttribute("updateData", updateData);
																	 * model.addAttribute("data", qvo); return
																	 * "admin/qna/updateForm"; }
																	 * 
																	 *//**************************************************************
																		 * �ۼ��� �����ϱ�
																		 * 
																		 * @param :
																		 *            QnaVO
																		 **************************************************************/
	/*
	 * @RequestMapping(value = "/qna/qnaUpdate.do", method = RequestMethod.POST)
	 * public String qnaUpdate(@ModelAttribute QnaVO qvo, HttpServletRequest
	 * request) throws IllegalStateException, IOException {
	 * logger.info("qnaUpdate ȣ�� ����"); int result = 0; String url = ""; String
	 * b_file=""; System.out.println("Ÿ���� ������ư");
	 * 
	 * if(!qvo.getFile().isEmpty()) { logger.info("======== file = "
	 * +qvo.getFile().getOriginalFilename()); if(!qvo.getB_file().isEmpty()) {
	 * FileUploadUtil.fileDelete(qvo.getB_file(), request); } b_file =
	 * FileUploadUtil.fileUpload(qvo.getFile(), request, "qna");
	 * qvo.setB_file(b_file); }else { logger.info("÷������ ����"); qvo.setB_file(""); }
	 * System.out.println(qvo.getQ_content()); result =
	 * adminQnaService.qnaUpdate(qvo); if (result == 1) { url="/qna/qnaList.do"; //
	 * ���� �� ������� �̵� // �Ʒ� url�� ���� �� �� �������� �̵� url = "/qna/qnaDetail.do?q_num=" +
	 * qvo.getQnum(); } else { url = "/qna/updateForm.do??q_num=" + qvo.getQnum(); }
	 * return "redirect:" + url; }
	 * 
	 *//**************************************************************
		 * �ۻ��� �����ϱ�
		 * 
		 * @throws IOException
		 **************************************************************//*
																		 * @RequestMapping(value = "/qna/qnaDelete.do",
																		 * method = RequestMethod.GET) public String
																		 * qnaDelete(@ModelAttribute QnaVO qvo,
																		 * HttpServletRequest request) throws
																		 * IOException { logger.info("qnaDelete ȣ�� ����");
																		 * // �Ʒ� �������� �Է� ������ ���� ���°� ����ϴ�.(1 or 0) int
																		 * result = 0; String url = "";
																		 * 
																		 * if(!qvo.getB_file().isEmpty()) {
																		 * FileUploadUtil.fileDelete(qvo.getB_file(),
																		 * request); }
																		 * 
																		 * result =
																		 * adminQnaService.qnaDelete(qvo.getQnum()); if
																		 * (result == 1) { url = "admin/qna/qnaList.do";
																		 * } else { url =
																		 * "admin/qna/qnaDetail.do?q_num=" +
																		 * qvo.getQnum(); } return "redirect:" + url; }
																		 */
}
