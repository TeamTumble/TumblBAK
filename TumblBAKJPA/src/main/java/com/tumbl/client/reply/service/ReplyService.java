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

	// �۸�� ����

	public List<ReplyVO> replyList(Integer qnum) {
		List<ReplyVO> myList = null;
		myList = replyRepository.findByQnum(qnum);
		return myList;
	}

	// ���Է� ����

	public void replyInsert(ReplyVO rvo) {
		
		System.out.println("���� ����  qnum =======  "   + rvo.getqnum());

		try {
			replyRepository.save(rvo);
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	// �ۼ��� ����

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

	// �ۻ��� ����

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
