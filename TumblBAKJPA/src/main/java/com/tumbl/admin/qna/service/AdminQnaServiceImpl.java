/*package com.tumbl.admin.qna.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.admin.qna.dao.AdminQnaDao;
import com.tumbl.client.qna.vo.QnaVO;

@Service
@Transactional
public class AdminQnaServiceImpl implements AdminQnaService {
	Logger logger = Logger.getLogger(AdminQnaServiceImpl.class);
	@Autowired
	private AdminQnaDao adminQnaDao;

	// �۸�� ����
	@Override
	public List<QnaVO> qnaList(QnaVO qvo) {
		List<QnaVO> myList = null;

		// ���Ŀ� ���� �⺻�� ����
		if (qvo.getOrder_by() == null) {
			qvo.setOrder_by("q_num");
		}
		if (qvo.getOrder_sc() == null) {
			qvo.setOrder_sc("DESC");
		}

		myList = adminQnaDao.qnaList(qvo);
		return myList;
	}
	
	// ��ü ���ڵ� �� ����
	@Override
	public int qnaListCnt(QnaVO qvo) {
		return adminQnaDao.qnaListCnt(qvo);
		}

	// ���Է� ����
	@Override
	public int qnaInsert(QnaVO qvo) {
		int result = 0;
		try {
			result = adminQnaDao.qnaInsert(qvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// �ۻ� ����
	@Override
	public QnaVO qnaDetail(QnaVO qvo) {
		QnaVO detail = null;
		detail = adminQnaDao.qnaDetail(qvo);
		return detail;
	}

	// ��й�ȣ Ȯ�� ����
	@Override
	public int pwdConfirm(QnaVO qvo) {
		int result = 0;
		result = adminQnaDao.pwdConfirm(qvo);
		return result;
	}

	// �ۼ��� ����
	@Override
	public int qnaUpdate(QnaVO qvo) {
		int result = 0;
		try {
			result = adminQnaDao.qnaUpdate(qvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// �ۻ��� ����
	@Override
	public int qnaDelete(int q_num) {
		int result = 0;
		try {
			result = adminQnaDao.qnaDelete(q_num);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
}
*/