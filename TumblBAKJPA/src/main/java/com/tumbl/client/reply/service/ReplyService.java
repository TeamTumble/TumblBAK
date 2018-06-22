package com.tumbl.client.reply.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tumbl.client.reply.repository.ReplyRepository;
import com.tumbl.client.reply.vo.ReplyVO;

@Service
public class ReplyService {

	@Resource
	ReplyRepository replyRepository;

	// 글목록 구현

	public List<ReplyVO> replyList(Integer qnum) {
		List<ReplyVO> myList = null;
		myList = replyRepository.findByQnum(qnum);
		return myList;
	}

	// 글입력 구현

	public void replyInsert(ReplyVO rvo) {
		
		System.out.println("리플 서비스  qnum =======  "   + rvo.getqnum());

		try {
			replyRepository.save(rvo);
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	// 글수정 구현

	public int replyUpdate(ReplyVO rvo) {
		int result = 0;
		try {
			replyRepository.save(rvo);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글삭제 구현

	public int replyDelete(int rnum) {
		int result = 0;
		try {
			replyRepository.delete(rnum);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

}
