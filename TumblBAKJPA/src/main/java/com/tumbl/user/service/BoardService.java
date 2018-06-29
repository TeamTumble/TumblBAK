package com.tumbl.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.user.repository.BoardRepository;
import com.tumbl.user.vo.QnaVO;

@Service
public class BoardService {
	Logger logger = Logger.getLogger(BoardService.class);

	@Resource
	BoardRepository boardRepository;

	// 글목록 구현
	public List<QnaVO> boardList(QnaVO bvo) {
		List<QnaVO> myList = null;

		myList = boardRepository.findAll();
		return myList;
	}

	// 글 레코드 수
	public long countBoard(QnaVO bvo) {
		long gg = boardRepository.count();
		return gg;
	}

	public Page<QnaVO> findAll(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	// 글입력 구현
	public QnaVO boardInsert(QnaVO bvo) {
		try {
			boardRepository.save(bvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bvo;
	}

	// 글상세 구현
	public QnaVO boardDetail(QnaVO bvo) {
		QnaVO detail = null;
		detail = boardRepository.findOne(bvo.getQnum());
		System.out.println("디테일 서비스  ========== " + detail);
		return detail;

	}

	// 글수정 구현//
	public QnaVO boardUpdate(QnaVO bvo) {
		boardRepository.save(bvo);
		return bvo;
	}

	// 글삭제 구현//
	public void boardDelete(long qnum) {
		try {
			boardRepository.delete(qnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Page<QnaVO> findByEmailContaining(String email, Pageable pageable) {
		System.out.println("서비스 검색 이메일 =============  " + email);
		return boardRepository.findByEmailContaining(email, pageable);
	}

	public Page<QnaVO> findByQtitleContaining(String qtitle, Pageable pageable) {
		return boardRepository.findByQtitleContaining(qtitle, pageable);
	}
}
