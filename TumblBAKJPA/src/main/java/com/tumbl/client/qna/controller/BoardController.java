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
	 * 글목록 구현하기
	 **************************************************************/
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardList(@ModelAttribute QnaVO qvo, Model model, HttpSession session) {
		logger.info("boardList 호출 성공");

		// 페이지 세팅
		Paging.setPage(qvo);

		Login login = (Login) session.getAttribute("login");

		qvo.setEmail(login.getEmail());
		// 글번호 재설정

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
	 * 글쓰기 폼 출력하기
	 **************************************************************/
	@RequestMapping(value = "/writeForm.do")
	public ModelAndView writeForm(HttpSession session) {
		logger.info("writeForm 호출 성공");
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
	 * 글쓰기 구현하기
	 **************************************************************/
	@RequestMapping(value = "/boardInsert.do", method = RequestMethod.POST)
	public String boardInsert(@ModelAttribute QnaVO bvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("boardInsert 호출 성공");
		System.out.println("글쓰기 파일");
		QnaVO result = new QnaVO();
		String url = "";
		Date todate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		String dTime = formatter.format(todate);

		if (bvo.getFile() != null) {
			System.out.println("파일첨부");
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
	 * 글 상세보기 구현
	 **************************************************************/
	@RequestMapping(value = "/boardDetail.do", method = RequestMethod.GET)
	public String boardDetail(@ModelAttribute QnaVO pvo, Model model) {
		logger.info("boardDetail 호출 성공");
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
	 * 글수정 폼 출력하기
	 * 
	 * @param :
	 *            b_num
	 * @return : BoardVO
	 **************************************************************/
	@RequestMapping(value = "/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute QnaVO bvo, Model model) {
		logger.info("updateForm 호출 성공");
		logger.info("b_num = " + bvo.getQnum());
		QnaVO updateData = new QnaVO();

		updateData = boardService.boardDetail(bvo);
		System.out.println("글수정 폼  ======= " + updateData);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", bvo);
		return "board/updateForm";
	}

	/**************************************************************
	 * 글수정 구현하기
	 * 
	 * @param :
	 *            BoardVO
	 **************************************************************/

	@RequestMapping(value = "/boardUpdate.do", method = RequestMethod.POST)
	public String boardUpdate(@ModelAttribute QnaVO bvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("boardUpdate 호출 성공");
		String url = "";
		String b_file = "";
		System.out.println("타지나 수정버튼");

		if (!bvo.getFile().isEmpty()) {
			logger.info("======== file = " + bvo.getFile().getOriginalFilename());
			if (!bvo.getB_file().isEmpty()) {
				FileUploadUtil.fileDelete(bvo.getB_file(), request);
			}
			b_file = FileUploadUtil.fileUpload(bvo.getFile(), request, "board");
			bvo.setB_file(b_file);
		} else {
			logger.info("첨부파일 없음");
			bvo.setB_file("");
		}
		System.out.println(bvo.getEmail());
		boardService.boardUpdate(bvo);

		url = "/board/boardDetail.do?q_num=" + bvo.getQnum();

		return "redirect:" + url;
	}

	/**************************************************************
	 * 글삭제 구현하기
	 * 
	 * @throws IOException
	 **************************************************************/
	@RequestMapping(value = "/boardDelete.do", method = RequestMethod.GET)
	public String boardDelete(@ModelAttribute QnaVO bvo, HttpServletRequest request) throws IOException {
		logger.info("boardDelete 호출 성공");
		// 아래 변수에는 입력 성공에 대한 상태값 담습니다.(1 or 0)
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
