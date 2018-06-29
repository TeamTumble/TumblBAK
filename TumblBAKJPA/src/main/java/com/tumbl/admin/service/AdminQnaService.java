package com.tumbl.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.user.repository.BoardRepository;
import com.tumbl.user.vo.QnaVO;

@Service
public class AdminQnaService {

	@Resource
	BoardRepository boardRepository;

	public List<QnaVO> qnaAdminList(QnaVO qvo) {
		List<QnaVO> myList = null;
		myList = boardRepository.findAll();
		return myList;
	}

	public int qnaListCnt(int qnum) {
		return boardRepository.countByQnum(qnum);
	}

	public long countAdminQna(QnaVO qvo) {
		List<QnaVO> myList = null;
		myList = boardRepository.findAll();
		long lqvo = boardRepository.count();
		return lqvo;
	}

	public Page<QnaVO> findAll(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	 public QnaVO qnaDetail(QnaVO qvo) {
			QnaVO detail = null;
			detail = boardRepository.findOne(qvo.getQnum());
			System.out.println("디테일 서비스  ========== " + detail);
			return detail;
	 }
	 
		public Page<QnaVO> findByEmailContaining(String email, PageRequest pageRequest) {

			return boardRepository.findByEmailContaining(email,pageRequest);
		}
		
		public Page<QnaVO> findByQtitleContaining(String qtitle, PageRequest pageRequest) {

			return boardRepository.findByQtitleContaining(qtitle,pageRequest);
		}
	
	
	/*
	 * public int qnaInsert(QnaVO qvo);
	 * 
	
	 
	 * public int pwdConfirm(QnaVO qvo);
	 * 
	 * public int qnaUpdate(QnaVO qvo);
	 * 
	 * public int qnaDelete(int q_num);
	 */
}
