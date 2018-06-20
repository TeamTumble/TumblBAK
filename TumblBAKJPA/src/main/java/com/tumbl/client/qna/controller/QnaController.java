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
	 * 글목록 구현하기
	 **************************************************************//*
	@RequestMapping(value = "/qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(@ModelAttribute QnaVO qvo, Model model, HttpSession session) {
		logger.info("qnaList 호출 성공");

		// 페이지 세팅
		Paging.setPage(qvo);
		// 전체 레코드수 구현
		int total = qnaService.qnaListCnt(qvo);
		logger.info("total = " + total);
		ModelAndView mav = new ModelAndView();
		// 글번호 재설정
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
	 * 글 상세보기 구현
	 **************************************************************//*
	@RequestMapping(value = "/qnaDetail.do", method = RequestMethod.GET)
	public String qnaDetail(@ModelAttribute QnaVO pvo, Model model) {
		logger.info("qnaDetail 호출 성공");
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
	 * 비밀번호 확인
	 * 
	 * @param b_num
	 * @param b_pwd
	 * @return int로 result를 0 또는 1를 리턴할 수도 있고, String로 result 값을 "성공 or 실패"를 리턴할 수도
	 *         있다.(현재 문자열 리턴) 참고 : @ResponseBody는 전달된 뷰를 통해서 출력하는 것이 아니라 HTTP
	 *         Response Body에 직접 출력하는 방식. produces 속성은 지정한 미디어 타입과 관련된 응답을 생성하는데 사용한
	 *         실제 컨텐트 타입을 보장.
	 **************************************************************//*
	@ResponseBody
	@RequestMapping(value = "/pwdConfirm.do", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public String pwdConfirm(@ModelAttribute QnaVO qvo) {
		logger.info("pwdConfirm 호출 성공");
		String value = "";
		// 아래 변수에는 입력 성공에 대한 상태값 저장(1 or 0)
		int result = qnaService.pwdConfirm(qvo);
		if (result == 1) {
			value = "성공";
		} else {
			value = "실패";
		}
		logger.info("result = " + result);
		return value + "";
	}

	*//**************************************************************
	 * 글수정 폼 출력하기
	 * 
	 * @param :
	 *            b_num
	 * @return : QnaVO
	 **************************************************************//*
	@RequestMapping(value = "/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute QnaVO qvo, Model model) {
		logger.info("updateForm 호출 성공");
		logger.info("b_num = " + qvo.getQ_num());
		QnaVO updateData = new QnaVO();
		
		updateData = qnaService.qnaDetail(qvo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", qvo);
		return "qna/updateForm";
	}

	*//**************************************************************
	 * 글수정 구현하기
	 * 
	 * @param :
	 *            QnaVO
	 **************************************************************//*
	@RequestMapping(value = "/qnaUpdate.do", method = RequestMethod.POST)
	public String qnaUpdate(@ModelAttribute QnaVO qvo, HttpServletRequest request) throws IllegalStateException, IOException {
		logger.info("qnaUpdate 호출 성공");
		int result = 0;
		String url = "";
		String b_file="";
		System.out.println("타지나 수정버튼");
		
		if(!qvo.getFile().isEmpty()) {
			logger.info("======== file = " +qvo.getFile().getOriginalFilename());
			if(!qvo.getB_file().isEmpty()) {
				FileUploadUtil.fileDelete(qvo.getB_file(), request);
			}
			b_file = FileUploadUtil.fileUpload(qvo.getFile(), request, "qna");
			qvo.setB_file(b_file);
		}else {
			logger.info("첨부파일 없음");
			qvo.setB_file("");
		}
		System.out.println(qvo.getQ_content());
		result = qnaService.qnaUpdate(qvo);
		if (result == 1) {
			// url="/qna/qnaList.do"; // 수정 후 목록으로 이동
			// 아래 url은 수정 후 상세 페이지로 이동
			url = "/qna/qnaDetail.do?q_num=" + qvo.getQ_num();
		} else {
			url = "/qna/updateForm.do??q_num=" + qvo.getQ_num();
		}
		return "redirect:" + url;
	}

	*//**************************************************************
	 * 글삭제 구현하기
	 * 
	 * @throws IOException
	 **************************************************************//*
	@RequestMapping(value = "/qnaDelete.do", method = RequestMethod.GET)
	public String qnaDelete(@ModelAttribute QnaVO qvo, HttpServletRequest request) throws IOException {
		logger.info("qnaDelete 호출 성공");
		// 아래 변수에는 입력 성공에 대한 상태값 담습니다.(1 or 0)
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