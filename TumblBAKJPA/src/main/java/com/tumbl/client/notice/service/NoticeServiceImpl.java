package com.tumbl.client.notice.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.admin.notice.dao.AdminNoticeDao;
import com.tumbl.admin.notice.vo.NoticeVO;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	Logger logger = Logger.getLogger(NoticeServiceImpl.class);
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

	

	// �ۻ� ����
	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		NoticeVO detail = null;
		detail = adminNoticeDao.noticeDetail(nvo);
		return detail;
	}

	
}
