/*package com.tumbl.admin.support.controller;

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
import com.tumbl.admin.support.service.AdminSupportService;
import com.tumbl.client.support.vo.SupportVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminSupportController {
	Logger logger = Logger.getLogger(AdminSupportController.class);

	@Autowired
	private AdminSupportService adminSupportService;

	*//**************************************************************
	 * 글목록 구현하기
	 **************************************************************//*
	@RequestMapping(value = "/support/supportList.do", method = RequestMethod.GET)
	public String supportList(@ModelAttribute SupportVO svo, Model model) {
		logger.info("/support/supportList 호출 성공");

		// 페이지 세팅
		Paging.setPage(svo);
		// 전체 레코드수 구현
		int total = adminSupportService.supportListCnt(svo);
		logger.info("total = " + total);

		// 글번호 재설정
		int count = total - (Util.nvl(svo.getPage()) - 1) * Util.nvl(svo.getPageSize());
		logger.info("count = " + count);

		List<SupportVO> supportList = adminSupportService.supportList(svo);

		model.addAttribute("supportList", supportList);
		model.addAttribute("count", count);
		model.addAttribute("total", total);
		model.addAttribute("data", svo);
		return "admin/support/supportList";
	}

	*//**************************************************************
	 * 글쓰기 폼 출력하기
	 **************************************************************//*
	@RequestMapping(value = "/support/writeForm.do")
	public String writeForm() {
		logger.info("writeForm 호출 성공");
		return "admin/support/writeForm";	
	}

	*//**************************************************************
	 * 글쓰기 구현하기
	 **************************************************************//*
	@RequestMapping(value = "/support/supportInsert.do", method = RequestMethod.POST)
	public String supportInsert(@ModelAttribute SupportVO svo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("supportInsert 호출 성공");
		int result = 0;
		String url = "";

		result = adminSupportService.supportInsert(svo);
		if (result == 1) {
			url = "/admin/support/supportList.do";
		} else {
			model.addAttribute("code", 1);
			url = "/admin/support/writeForm.do";
		}
		return "redirect:" + url;
	}

	*//**************************************************************
	 * 글 상세보기 구현
	 **************************************************************//*
	@RequestMapping(value = "/support/supportDetail.do", method = RequestMethod.GET)
	public String supportDetail(@ModelAttribute SupportVO svo, Model model) {
		logger.info("supportDetail 호출 성공");
		logger.info("s_no = " + svo.getS_no());
		SupportVO detail = new SupportVO();
		detail = adminSupportService.supportDetail(svo);
		if (detail != null && (!detail.equals(""))) {
			detail.setS_giftname(detail.getS_giftname().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "admin/support/supportDetail";
	}

	*//**************************************************************
	 * 비밀번호 확인
	 * 
	 * @param s_no
	 * @param s_pwd
	 * @return int로 result를 0 또는 1를 리턴할 수도 있고, String로 result 값을 "성공 or 실패"를 리턴할 수도
	 *         있다.(현재 문자열 리턴) 참고 : @ResponseBody는 전달된 뷰를 통해서 출력하는 것이 아니라 HTTP
	 *         Response Body에 직접 출력하는 방식. produces 속성은 지정한 미디어 타입과 관련된 응답을 생성하는데 사용한
	 *         실제 컨텐트 타입을 보장.
	 **************************************************************//*

	*//**************************************************************
	 * 글수정 폼 출력하기
	 * 
	 * @param :
	 *            s_no
	 * @return : SupportVO
	 **************************************************************//*
	@RequestMapping(value = "/support/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute SupportVO svo, Model model) {
		logger.info("updateForm 호출 성공");
		logger.info("s_no = " + svo.getS_no());
		SupportVO updateData = new SupportVO();

		updateData = adminSupportService.supportDetail(svo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", svo);
		return "admin/support/updateForm";
	}

	*//**************************************************************
	 * 글수정 구현하기
	 * 
	 * @param :
	 *            SupportVO
	 **************************************************************//*
	@RequestMapping(value = "/support/supportUpdate.do", method = RequestMethod.POST)
	public String supportUpdate(@ModelAttribute SupportVO svo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("supportUpdate 호출 성공");
		int result = 0;
		String url = "";

		result = adminSupportService.supportUpdate(svo);
		if (result == 1) {
			// url="/support/supportList.do"; // 수정 후 목록으로 이동
			// 아래 url은 수정 후 상세 페이지로 이동
			url = "/admin/support/supportDetail.do?s_no=" + svo.getS_no();
		} else {
			url = "/admin/support/updateForm.do??s_no=" + svo.getS_no();
		}
		return "redirect:" + url;
	}

	*//**************************************************************
	 * 글삭제 구현하기
	 * 
	 * @throws IOException
	 **************************************************************//*
	@RequestMapping(value = "/support/supportDelete.do")
	public String supportDelete(@ModelAttribute SupportVO svo, HttpServletRequest request) throws IOException {
		logger.info("supportDelete 호출 성공");
		// 아래 변수에는 입력 성공에 대한 상태값 담습니다.(1 or 0)
		int result = 0;

		result = adminSupportService.supportDelete(svo.getS_no());
		
		return "redirect:" + "/admin/support/supportList.do";
	}
}
*/