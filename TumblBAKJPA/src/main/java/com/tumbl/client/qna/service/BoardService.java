package com.tumbl.client.qna.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.client.qna.repository.BoardRepository;
import com.tumbl.client.qna.vo.QnaVO;

@Service
public class BoardService {
	Logger logger = Logger.getLogger(BoardService.class);

	@Autowired
	BoardRepository boardRepository;

	// �۸�� ����

	public List<QnaVO> boardList(QnaVO bvo) {
		List<QnaVO> myList = null;

		myList = boardRepository.findAll();
		return myList;
	}

	public int boardCnt(int qnum) {
		return boardRepository.countByQnum(qnum);
	}

	public long countBoard(QnaVO bvo) {
		List<QnaVO> myList = null;

		myList = boardRepository.findAll();
		long gg = boardRepository.count();

		return gg;

	}

	public Page<QnaVO> findAll(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	// ���Է� ����

	public QnaVO boardInsert(QnaVO bvo) {

		try {
			boardRepository.save(bvo);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return bvo;

	}

	// �ۻ� ����

	public QnaVO boardDetail(QnaVO bvo) {
		QnaVO detail = null;
		detail = boardRepository.findOne(bvo.getQnum());
		return detail;

	}

	// �ۼ��� ����//

	public void boardUpdate(QnaVO bvo) {

		try {
			boardRepository.save(bvo);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// �ۻ��� ����//

	public void boardDelete(long q_num) {
		
		try {
			 boardRepository.delete(q_num);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
