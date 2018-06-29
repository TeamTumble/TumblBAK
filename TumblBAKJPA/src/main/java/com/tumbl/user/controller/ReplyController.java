package com.tumbl.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tumbl.user.service.ReplyService;
import com.tumbl.user.vo.ReplyVO;

/**************************************************************
 * 참고 : @RestController (@Controller + @ResponesBody) 
 * 기존의 특정한 JSP와 같은 뷰를 만들어
 * 내는 것이 목적이 아닌 REST 방식의 데이터 처리를 
 * 위해서 사용하는(데이터 자체를 반환) 어노테이션이다.
 **************************************************************/
@RestController
@RequestMapping(value = "/replies")
public class ReplyController {
	Logger logger = Logger.getLogger(ReplyController.class);
	@Resource
    ReplyService replyService;

	/**************************************************************
	 *  댓글 글목록 구현하기 * @return List<ReplyVO>
     *	참고 : @PathVariable는 URI의 경로에서 원하는
	 * 데이터를 추출하는 용도의 어노테이션. * 현재 요청 URL :
	 * http://localhost:8080/replies/all/게시판글번호.do * 예전 요청 URL :
	 * http://localhost:8080/replies/replyList.do?qnum=게시판글번호
	 **************************************************************/
	@RequestMapping(value = "/all/{qnum}.do", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("qnum") Integer qnum) {
		ResponseEntity<List<ReplyVO>> entity = null;
		System.out.println("리플쪽  qnum ===============  " +qnum);
		try {
			entity = new ResponseEntity<List<ReplyVO>>(replyService.replyList(qnum), HttpStatus.OK);
			System.out.println("리플쪽 엔티티 밑 ======================== " +qnum);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
	    System.out.println("밑에쪽  엔티티  ==========  " + entity);
		return entity;
	}

	/**************************************************************
	 * * 댓글 글쓰기 구현하기 
	 * * @return String 
	 * * 참고 : @RequestBody
	 **************************************************************/
	@RequestMapping(value="/replyInsert")  
	public ResponseEntity<String> replyInsert(@RequestBody ReplyVO rvo) {
		logger.info("replyInsert 호출 성공");
		ResponseEntity<String> entity = null;
		System.out.println("댓글 글쓰기 rvo =============== "  +rvo);
		int result;
		try {
			replyService.replyInsert(rvo);
			
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}


	/**************************************************************
	 * * 댓글 수정 구현하기 
	 * * @return 
	 * * 참고 : REST 방식에서 UPDATE 작업은 PUT,PATCH방식을 이용해서 처리. 
	 * * 전체
	 * 데이터를 수정하는 경우에는 PUT을 이용하고, 
	 * * 일부의 데이터를 수정하는 경우에는 PATCH를 이용.
	 **************************************************************/
	@RequestMapping(value = "/{rnum}.do", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> replyUpdate(@PathVariable("rnum") Integer rnum, @RequestBody ReplyVO rvo) {
		logger.info("replyUpdate 호출 성공");
		ResponseEntity<String> entity = null;
		try {
			rvo.setRnum(rnum);
			replyService.replyUpdate(rvo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/**************************************************************
	 * 댓글 삭제 구현하기
	 * 
	 * @return 참고 : REST 방식에서 DELETE 작업은 DELETE방식을 이용해서 처리.
	 **************************************************************/
	@RequestMapping(value = "/{rnum}.do", method = RequestMethod.DELETE)
	public ResponseEntity<String> replyDelete(@PathVariable("rnum") Integer rnum) {
		logger.info("replyDelete 호출 성공");
		ResponseEntity<String> entity = null;
		try {
			replyService.replyDelete(rnum);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
