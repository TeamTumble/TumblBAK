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
	 * 글목록 구현하기
	 **************************************************************/
	@RequestMapping(value = "/qna/qnaList.do", method = RequestMethod.GET)
	public String qnaList(@ModelAttribute QnaVO qvo, Model model, HttpSession session) {
		logger.info("qnaList 호출 성공");

		// 페이지 세팅
		Paging.setPage(qvo);
		// 전체 레코드수 구현

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
				System.out.println("검색 컨트롤러      ==============  " + qvo.getKeyword());
				System.out.println("이메일 검색 컨트롤러      ==============  탑승 확인");
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
				System.out.println("검색 컨트롤러      ==============  " + qvo.getKeyword());
				System.out.println("타이틀 검색 컨트롤러      ==============  탑승 확인");
				Page<QnaVO> page = adminQnaService.findByQtitleContaining(qvo.getKeyword(), pageRequest);
				List<QnaVO> cQvo = page.getContent();
				System.out.println("타이틀 검색 컨트롤러      ============== " + cQvo);
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
	 * 글 상세보기 구현
	 **************************************************************/
	@RequestMapping(value = "/qna/qnaDetail.do", method = RequestMethod.GET)
	public String qnaDetail(@ModelAttribute QnaVO qvo, Model model) {
		logger.info("qnaDetail 호출 성공");
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
	 * 글쓰기 폼 출력하기
	 **************************************************************/
	/*
	 * @RequestMapping(value = "/qna/writeForm.do") public String writeForm() {
	 * logger.info("writeForm 호출 성공"); return "admin/qna/writeForm"; }
	 */

	/**************************************************************
	 * 글쓰기 구현하기
	 **************************************************************/
	/*
	 * @RequestMapping(value = "/qna/qnaInsert.do", method = RequestMethod.POST)
	 * public String qnaInsert(@ModelAttribute QnaVO qvo, Model model,
	 * HttpServletRequest request) throws IllegalStateException, IOException {
	 * logger.info("qnaInsert 호출 성공"); int result = 0; String url = "";
	 * 
	 * result = adminQnaService.qnaInsert(qvo); if (result == 1) { url =
	 * "/admin/qna/qnaList.do"; } else { model.addAttribute("code", 1); url =
	 * "/admin/qna/writeForm.do"; } return "redirect:" + url; }
	 */
	/**************************************************************
	 * 비밀번호 확인
	 * 
	 * @param q_num
	 * @param q_pwd
	 * @return int로 result를 0 또는 1를 리턴할 수도 있고, String로 result 값을 "성공 or 실패"를 리턴할 수도
	 *         있다.(현재 문자열 리턴) 참고 : @ResponseBody는 전달된 뷰를 통해서 출력하는 것이 아니라 HTTP
	 *         Response Body에 직접 출력하는 방식. produces 속성은 지정한 미디어 타입과 관련된 응답을 생성하는데 사용한
	 *         실제 컨텐트 타입을 보장.
	 **************************************************************/
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/qna/pwdConfirm.do", method = RequestMethod.POST,
	 * produces = "text/plain; charset=UTF-8") public String
	 * pwdConfirm(@ModelAttribute QnaVO qvo) { logger.info("pwdConfirm 호출 성공");
	 * String value = ""; // 아래 변수에는 입력 성공에 대한 상태값 저장(1 or 0) int result =
	 * adminQnaService.pwdConfirm(qvo); if (result == 1) { value = "성공"; } else {
	 * value = "실패"; } logger.info("result = " + result); return value + ""; }
	 * 
	 * /************************************************************** 글수정 폼 출력하기
	 * 
	 * @param : q_num
	 * 
	 * @return : QnaVO
	 **************************************************************//*
																	 * @RequestMapping(value = "/qna/updateForm.do",
																	 * method = RequestMethod.GET) public String
																	 * updateForm(@ModelAttribute QnaVO qvo, Model
																	 * model) { logger.info("updateForm 호출 성공");
																	 * logger.info("q_num = " + qvo.getQnum()); QnaVO
																	 * updateData = new QnaVO();
																	 * 
																	 * updateData = adminQnaService.qnaDetail(qvo);
																	 * model.addAttribute("updateData", updateData);
																	 * model.addAttribute("data", qvo); return
																	 * "admin/qna/updateForm"; }
																	 * 
																	 *//**************************************************************
																		 * 글수정 구현하기
																		 * 
																		 * @param :
																		 *            QnaVO
																		 **************************************************************/
	/*
	 * @RequestMapping(value = "/qna/qnaUpdate.do", method = RequestMethod.POST)
	 * public String qnaUpdate(@ModelAttribute QnaVO qvo, HttpServletRequest
	 * request) throws IllegalStateException, IOException {
	 * logger.info("qnaUpdate 호출 성공"); int result = 0; String url = ""; String
	 * b_file=""; System.out.println("타지나 수정버튼");
	 * 
	 * if(!qvo.getFile().isEmpty()) { logger.info("======== file = "
	 * +qvo.getFile().getOriginalFilename()); if(!qvo.getB_file().isEmpty()) {
	 * FileUploadUtil.fileDelete(qvo.getB_file(), request); } b_file =
	 * FileUploadUtil.fileUpload(qvo.getFile(), request, "qna");
	 * qvo.setB_file(b_file); }else { logger.info("첨부파일 없음"); qvo.setB_file(""); }
	 * System.out.println(qvo.getQ_content()); result =
	 * adminQnaService.qnaUpdate(qvo); if (result == 1) { url="/qna/qnaList.do"; //
	 * 수정 후 목록으로 이동 // 아래 url은 수정 후 상세 페이지로 이동 url = "/qna/qnaDetail.do?q_num=" +
	 * qvo.getQnum(); } else { url = "/qna/updateForm.do??q_num=" + qvo.getQnum(); }
	 * return "redirect:" + url; }
	 * 
	 *//**************************************************************
		 * 글삭제 구현하기
		 * 
		 * @throws IOException
		 **************************************************************//*
																		 * @RequestMapping(value = "/qna/qnaDelete.do",
																		 * method = RequestMethod.GET) public String
																		 * qnaDelete(@ModelAttribute QnaVO qvo,
																		 * HttpServletRequest request) throws
																		 * IOException { logger.info("qnaDelete 호출 성공");
																		 * // 아래 변수에는 입력 성공에 대한 상태값 담습니다.(1 or 0) int
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
