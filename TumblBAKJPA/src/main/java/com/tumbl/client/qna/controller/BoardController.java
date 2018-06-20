package com.tumbl.client.qna.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.client.common.page.Paging;
import com.tumbl.client.login.vo.Login;
import com.tumbl.client.member.service.MemberService;
import com.tumbl.client.member.vo.Member;
import com.tumbl.client.qna.service.BoardService;
import com.tumbl.client.qna.vo.QnaVO;
import com.tumbl.common.file.FileUploadUtil;
import com.tumbl.common.util.Util;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	Logger logger = Logger.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@Autowired
	private MemberService memberService;

	/***************************************************************
	 * �۸�� �����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardList(@ModelAttribute QnaVO qvo, Model model, HttpSession session) {
		logger.info("boardList ȣ�� ����");

		// ������ ����
		Paging.setPage(qvo);

		Login login = (Login) session.getAttribute("login");

		qvo.setEmail(login.getEmail());
		// �۹�ȣ �缳��

		long total = boardService.countBoard(qvo);
		System.out.println(qvo.getPage() + "       " + qvo.getPageSize());
		long count = total - (Util.nvl(qvo.getPage()) - 1) * Util.nvl(qvo.getPageSize());
		PageRequest pageRequest = new PageRequest(Util.nvl(qvo.getPage()) - 1, Util.nvl(qvo.getPageSize()),
				new Sort(Direction.DESC, "qnum"));
		Page<QnaVO> page = boardService.findAll(pageRequest);
		List<QnaVO> cQvo = page.getContent();

		model.addAttribute("boardList", cQvo);
		model.addAttribute("test", page.getNumberOfElements());
		model.addAttribute("count", count);
		model.addAttribute("total", total);
		model.addAttribute("data", qvo);

		return "board/boardList";

	}

	/**************************************************************
	 * �۾��� �� ����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/writeForm.do")
	public ModelAndView writeForm(HttpSession session) {
		logger.info("writeForm ȣ�� ����");
		ModelAndView mav = new ModelAndView();
		Login login = (Login) session.getAttribute("login");
		if (login == null) {
			mav.setViewName("member/login");
			return mav;
		}
		Member vo = memberService.findByemail(login.getEmail());
		mav.addObject("member", vo);
		mav.setViewName("board/writeForm");
		return mav;
	}

	/**************************************************************
	 * �۾��� �����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/boardInsert.do", method = RequestMethod.POST)
	public String boardInsert(@ModelAttribute QnaVO bvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("boardInsert ȣ�� ����");
		System.out.println("�۾��� ����");
		QnaVO result = new QnaVO();
		String url = "";
		Date todate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		String dTime = formatter.format(todate);

		if (bvo.getFile() != null) {
			System.out.println("����÷��");
			String b_file = FileUploadUtil.fileUpload(bvo.getFile(), request, "qna");
			bvo.setB_file(b_file);
		}
		bvo.setQ_date(dTime);

		result = boardService.boardInsert(bvo);
		if (result != null) {
			url = "/board/boardList.do";
		} else {
			model.addAttribute("code", 1);
			url = "/board/writeForm.do";
		}
		return "redirect:" + url;
	}

	/**************************************************************
	 * �� �󼼺��� ����
	 **************************************************************/
	@RequestMapping(value = "/boardDetail.do", method = RequestMethod.GET)
	public String boardDetail(@ModelAttribute QnaVO pvo, Model model) {
		logger.info("boardDetail ȣ�� ����");
		logger.info("b_num = " + pvo.getQnum());
		QnaVO detail = new QnaVO();
		detail = boardService.boardDetail(pvo);

		if (detail != null && (!detail.equals(""))) {
			detail.setQ_content(detail.getQ_content().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "board/boardDetail";
	}

	/**************************************************************
	 * �ۼ��� �� ����ϱ�
	 * 
	 * @param :
	 *            b_num
	 * @return : BoardVO
	 **************************************************************/
	@RequestMapping(value = "/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute QnaVO bvo, Model model) {
		logger.info("updateForm ȣ�� ����");
		logger.info("b_num = " + bvo.getQnum());
		QnaVO updateData = new QnaVO();

		updateData = boardService.boardDetail(bvo);
		System.out.println("�ۼ��� ��  ======= " + updateData);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", bvo);
		return "board/updateForm";
	}

	/**************************************************************
	 * �ۼ��� �����ϱ�
	 * 
	 * @param :
	 *            BoardVO
	 **************************************************************/

	@RequestMapping(value = "/boardUpdate.do", method = RequestMethod.POST)
	public String boardUpdate(@ModelAttribute QnaVO bvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("boardUpdate ȣ�� ����");
		String url = "";
		String b_file = "";
		System.out.println("Ÿ���� ������ư");

		if (!bvo.getFile().isEmpty()) {
			logger.info("======== file = " + bvo.getFile().getOriginalFilename());
			if (!bvo.getB_file().isEmpty()) {
				FileUploadUtil.fileDelete(bvo.getB_file(), request);
			}
			b_file = FileUploadUtil.fileUpload(bvo.getFile(), request, "board");
			bvo.setB_file(b_file);
		} else {
			logger.info("÷������ ����");
			bvo.setB_file("");
		}
		System.out.println(bvo.getEmail());
		boardService.boardUpdate(bvo);

		url = "/board/boardDetail.do?q_num=" + bvo.getQnum();

		return "redirect:" + url;
	}

	/**************************************************************
	 * �ۻ��� �����ϱ�
	 * 
	 * @throws IOException
	 **************************************************************/
	@RequestMapping(value = "/boardDelete.do", method = RequestMethod.GET)
	public String boardDelete(@ModelAttribute QnaVO bvo, HttpServletRequest request) throws IOException {
		logger.info("boardDelete ȣ�� ����");
		// �Ʒ� �������� �Է� ������ ���� ���°� ����ϴ�.(1 or 0)
		int result = 0;
		String url = "";

		if (!bvo.getB_file().isEmpty()) {
			FileUploadUtil.fileDelete(bvo.getB_file(), request);
		}

		boardService.boardDelete(bvo.getQnum());

		url = "/board/boardList.do";

		return "redirect:" + url;
	}
}
