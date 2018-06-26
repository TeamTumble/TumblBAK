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
	 * 글목록 구현하기
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeList.do", method = RequestMethod.GET)
	public String noticeList(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("/notice/noticeList 호출 성공");

		// 페이지 세팅
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
				System.out.println("검색 컨트롤러      ==============  " + nvo.getKeyword());
				System.out.println("ntitle 검색 컨트롤러      ==============  탑승 확인");
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
	 * 글쓰기 폼 출력하기
	 **************************************************************/
	@RequestMapping(value = "/notice/writeForm.do")
	public String writeForm() {
		logger.info("writeForm 호출 성공");

		// 로그인 세션 관련 뷰 띄우고 추가

		return "admin/notice/writeForm";
	}

	/**************************************************************
	 * 글쓰기 구현하기
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeInsert.do", method = RequestMethod.POST)
	public String noticeInsert(@ModelAttribute NoticeVO nvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("noticeInsert 호출 성공");
		System.out.println("글 쓰 기 파 일");
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
	 * 글 상세보기 구현
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeDetail.do", method = RequestMethod.GET)
	public String noticeDetail(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("noticeDetail 호출 성공");
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
	 * 비밀번호 확인
	 * 
	 * @param n_no
	 * @param n_pwd
	 * @return int로 result를 0 또는 1를 리턴할 수도 있고, String로 result 값을 "성공 or 실패"를 리턴할 수도
	 *         있다.(현재 문자열 리턴) 참고 : @ResponseBody는 전달된 뷰를 통해서 출력하는 것이 아니라 HTTP
	 *         Response Body에 직접 출력하는 방식. produces 속성은 지정한 미디어 타입과 관련된 응답을 생성하는데 사용한
	 *         실제 컨텐트 타입을 보장.
	 **************************************************************/

	/**************************************************************
	 * 글수정 폼 출력하기
	 * 
	 * @param :
	 *            n_no
	 * @return : NoticeVO
	 **************************************************************/
	@RequestMapping(value = "/notice/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute NoticeVO nvo, Model model) {
		logger.info("updateForm 호출 성공");
		logger.info("nno = " + nvo.getNno());
		NoticeVO updateData = new NoticeVO();

		updateData = adminNoticeService.noticeDetail(nvo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", nvo);
		return "admin/notice/updateForm";
	}

	/**************************************************************
	 * 글수정 구현하기
	 * 
	 * @param :
	 *            NoticeVO
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeUpdate.do", method = RequestMethod.POST)
	public String noticeUpdate(@ModelAttribute NoticeVO nvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("noticeUpdate 호출 성공");
		int result = 0;
		String url = "";

		Date todate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		String dTime = formatter.format(todate);
		nvo.setNdate(dTime);

		adminNoticeService.noticeUpdate(nvo);
		if (result != 1) {
			// url="/notice/noticeList.do"; // 수정 후 목록으로 이동
			// 아래 url은 수정 후 상세 페이지로 이동
			url = "/admin/notice/noticeDetail.do?nno=" + nvo.getNno();
		} else {
			url = "/admin/notice/updateForm.do?nno=" + nvo.getNno();
		}
		return "redirect:" + url;
	}

	/**************************************************************
	 * 글삭제 구현하기
	 * 
	 * @throws IOException
	 **************************************************************/
	@RequestMapping(value = "/notice/noticeDelete.do")
	public String noticeDelete(@ModelAttribute NoticeVO nvo, HttpServletRequest request) throws IOException {
		logger.info("noticeDelete 호출 성공");

		adminNoticeService.noticeDelete(nvo.getNno());

		return "redirect:" + "/admin/notice/noticeList.do";
	}
}
