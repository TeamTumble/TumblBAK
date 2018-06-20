/*package com.tumbl.client.qna.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.client.qna.dao.QnaDao;
import com.tumbl.client.qna.vo.QnaVO;

@Service
@Transactional
public class QnaServiceImpl implements QnaService {
	Logger logger = Logger.getLogger(QnaServiceImpl.class);
	@Autowired
	private QnaDao qnaDao;

	// 글목록 구현
	@Override
	public List<QnaVO> qnaList(QnaVO qvo) {
		List<QnaVO> myList = null;

		// 정렬에 대한 기본값 설정
		if (qvo.getOrder_by() == null) {
			qvo.setOrder_by("b_num");
		}
		if (qvo.getOrder_sc() == null) {
			qvo.setOrder_sc("DESC");
		}

		myList = qnaDao.qnaList(qvo);
		return myList;
	}
	
	// 전체 레코드 수 구현
	@Override
	public int qnaListCnt(QnaVO qvo) {
		return qnaDao.qnaListCnt(qvo);
		}

	// 글입력 구현
	@Override
	public int qnaInsert(QnaVO qvo) {
		int result = 0;
		try {
			result = qnaDao.qnaInsert(qvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글상세 구현
	@Override
	public QnaVO qnaDetail(QnaVO qvo) {
		QnaVO detail = null;
		detail = qnaDao.qnaDetail(qvo);
		return detail;
	}

	// 비밀번호 확인 구현
	@Override
	public int pwdConfirm(QnaVO qvo) {
		int result = 0;
		result = qnaDao.pwdConfirm(qvo);
		return result;
	}

	// 글수정 구현
	@Override
	public int qnaUpdate(QnaVO qvo) {
		int result = 0;
		try {
			result = qnaDao.qnaUpdate(qvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글삭제 구현
	@Override
	public int qnaDelete(int q_num) {
		int result = 0;
		try {
			result = qnaDao.qnaDelete(q_num);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
}
*/