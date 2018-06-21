package com.tumbl.client.qna.service;

import java.util.List;

import javax.annotation.Resource;

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

	@Resource
	BoardRepository boardRepository;

	// 글목록 구현

	public List<QnaVO> boardList(QnaVO bvo) {
		List<QnaVO> myList = null;

		myList = boardRepository.findAll();
		return myList;
	}

	

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
		/*QnaVO detail = null;
		detail = boardRepository.findOne(bvo.getQnum());
		System.out.println("서비스 업데이트 ======= " +bvo);
		System.out.println("서비스 업데이트 디테일  ======= " +detail);
		bvo.setEmail(detail.getEmail());
		bvo.setQ_date(detail.getQ_date());*/
		
			boardRepository.save(bvo);
		
			return bvo;
	}

	// 글삭제 구현//

	public void boardDelete(long q_num) {
		
		try {
			 boardRepository.delete(q_num);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
