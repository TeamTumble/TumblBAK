/*package com.tumbl.admin.notice.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.admin.notice.dao.AdminNoticeDao;
import com.tumbl.admin.notice.vo.NoticeVO;

@Service
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService {
	Logger logger = Logger.getLogger(AdminNoticeServiceImpl.class);
	@Autowired
	private AdminNoticeDao adminNoticeDao;

	// �۸�� ����
	@Override
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		List<NoticeVO> myList = null;

		// ���Ŀ� ���� �⺻�� ����
		if (nvo.getOrder_by() == null) {
			nvo.setOrder_by("n_no");
		}
		if (nvo.getOrder_sc() == null) {
			nvo.setOrder_sc("DESC");
		}

		myList = adminNoticeDao.noticeList(nvo);
		return myList;
	}

	// ��ü ���ڵ� �� ����
	@Override
	public int noticeListCnt(NoticeVO nvo) {
		return adminNoticeDao.noticeListCnt(nvo);
	}

	// ���Է� ����
	@Override
	public int noticeInsert(NoticeVO nvo) {
		int result = 0;
		try {
			result = adminNoticeDao.noticeInsert(nvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// �ۻ� ����
	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		NoticeVO detail = null;
		detail = adminNoticeDao.noticeDetail(nvo);
		return detail;
	}

	// �ۼ��� ����
	@Override
	public int noticeUpdate(NoticeVO nvo) {
		int result = 0;
		try {
			result = adminNoticeDao.noticeUpdate(nvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// �ۻ��� ����
	@Override
	public int noticeDelete(int n_no) {
		int result = 0;
		try {
			result = adminNoticeDao.noticeDelete(n_no);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

}
*/