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
 * ���� : @RestController (@Controller + @ResponesBody) 
 * ������ Ư���� JSP�� ���� �並 �����
 * ���� ���� ������ �ƴ� REST ����� ������ ó���� 
 * ���ؼ� ����ϴ�(������ ��ü�� ��ȯ) ������̼��̴�.
 **************************************************************/
@RestController
@RequestMapping(value = "/replies")
public class ReplyController {
	Logger logger = Logger.getLogger(ReplyController.class);
	@Resource
    ReplyService replyService;

	/**************************************************************
	 *  ��� �۸�� �����ϱ� * @return List<ReplyVO>
     *	���� : @PathVariable�� URI�� ��ο��� ���ϴ�
	 * �����͸� �����ϴ� �뵵�� ������̼�. * ���� ��û URL :
	 * http://localhost:8080/replies/all/�Խ��Ǳ۹�ȣ.do * ���� ��û URL :
	 * http://localhost:8080/replies/replyList.do?qnum=�Խ��Ǳ۹�ȣ
	 **************************************************************/
	@RequestMapping(value = "/all/{qnum}.do", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("qnum") Integer qnum) {
		ResponseEntity<List<ReplyVO>> entity = null;
		System.out.println("������  qnum ===============  " +qnum);
		try {
			entity = new ResponseEntity<List<ReplyVO>>(replyService.replyList(qnum), HttpStatus.OK);
			System.out.println("������ ��ƼƼ �� ======================== " +qnum);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
	    System.out.println("�ؿ���  ��ƼƼ  ==========  " + entity);
		return entity;
	}

	/**************************************************************
	 * * ��� �۾��� �����ϱ� 
	 * * @return String 
	 * * ���� : @RequestBody
	 **************************************************************/
	@RequestMapping(value="/replyInsert")  
	public ResponseEntity<String> replyInsert(@RequestBody ReplyVO rvo) {
		logger.info("replyInsert ȣ�� ����");
		ResponseEntity<String> entity = null;
		System.out.println("��� �۾��� rvo =============== "  +rvo);
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
	 * * ��� ���� �����ϱ� 
	 * * @return 
	 * * ���� : REST ��Ŀ��� UPDATE �۾��� PUT,PATCH����� �̿��ؼ� ó��. 
	 * * ��ü
	 * �����͸� �����ϴ� ��쿡�� PUT�� �̿��ϰ�, 
	 * * �Ϻ��� �����͸� �����ϴ� ��쿡�� PATCH�� �̿�.
	 **************************************************************/
	@RequestMapping(value = "/{rnum}.do", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> replyUpdate(@PathVariable("rnum") Integer rnum, @RequestBody ReplyVO rvo) {
		logger.info("replyUpdate ȣ�� ����");
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
	 * ��� ���� �����ϱ�
	 * 
	 * @return ���� : REST ��Ŀ��� DELETE �۾��� DELETE����� �̿��ؼ� ó��.
	 **************************************************************/
	@RequestMapping(value = "/{rnum}.do", method = RequestMethod.DELETE)
	public ResponseEntity<String> replyDelete(@PathVariable("rnum") Integer rnum) {
		logger.info("replyDelete ȣ�� ����");
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
