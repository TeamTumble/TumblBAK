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

	// �۸�� ����

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
		System.out.println("������ ����  ========== " + detail);
		return detail;

	}

	// �ۼ��� ����//

	public QnaVO boardUpdate(QnaVO bvo) {
		/*QnaVO detail = null;
		detail = boardRepository.findOne(bvo.getQnum());
		System.out.println("���� ������Ʈ ======= " +bvo);
		System.out.println("���� ������Ʈ ������  ======= " +detail);
		bvo.setEmail(detail.getEmail());
		bvo.setQ_date(detail.getQ_date());*/
		
			boardRepository.save(bvo);
		
			return bvo;
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
