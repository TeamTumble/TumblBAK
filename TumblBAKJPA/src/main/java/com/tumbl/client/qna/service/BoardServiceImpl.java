/*package com.tumbl.client.qna.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.client.qna.dao.BoardDao;
import com.tumbl.client.qna.vo.BoardVO;
import com.tumbl.client.qna.vo.QnaVO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	Logger logger = Logger.getLogger(BoardServiceImpl.class);
	@Autowired
	private BoardDao boardDao;

	// �۸�� ����
	@Override
	public List<QnaVO> boardList(QnaVO bvo) {
		List<QnaVO> myList = null;

		// ���Ŀ� ���� �⺻�� ����
		if (bvo.getOrder_by() == null) {
			bvo.setOrder_by("b_num");
		}
		if (bvo.getOrder_sc() == null) {
			bvo.setOrder_sc("DESC");
		}

		myList = boardDao.boardList(bvo);
		return myList;
	}
	
	// ��ü ���ڵ� �� ����
	@Override
	public int boardListCnt(QnaVO bvo) {
		return boardDao.boardListCnt(bvo);
		}

	// ���Է� ����
	@Override
	public int boardInsert(QnaVO bvo) {
		int result = 0;
		try {
			result = boardDao.boardInsert(bvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// �ۻ� ����
	@Override
	public QnaVO boardDetail(QnaVO bvo) {
		QnaVO detail = null;
		detail = boardDao.boardDetail(bvo);
		return detail;
	}

	// ��й�ȣ Ȯ�� ����
	@Override
	public int pwdConfirm(QnaVO bvo) {
		int result = 0;
		result = boardDao.pwdConfirm(bvo);
		return result;
	}

	// �ۼ��� ����
	@Override
	public int boardUpdate(QnaVO bvo) {
		int result = 0;
		try {
			result = boardDao.boardUpdate(bvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// �ۻ��� ����
	@Override
	public int boardDelete(int q_num) {
		int result = 0;
		try {
			result = boardDao.boardDelete(q_num);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
}
*/

