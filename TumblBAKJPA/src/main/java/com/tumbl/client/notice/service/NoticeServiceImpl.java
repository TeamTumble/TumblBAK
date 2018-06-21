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

	// 글목록 구현
	@Override
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		List<NoticeVO> myList = null;

		// 정렬에 대한 기본값 설정
		if (nvo.getOrder_by() == null) {
			nvo.setOrder_by("n_no");
		}
		if (nvo.getOrder_sc() == null) {
			nvo.setOrder_sc("DESC");
		}

		myList = adminNoticeDao.noticeList(nvo);
		return myList;
	}

	// 전체 레코드 수 구현
	@Override
	public int noticeListCnt(NoticeVO nvo) {
		return adminNoticeDao.noticeListCnt(nvo);
	}

	

	// 글상세 구현
	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		NoticeVO detail = null;
		detail = adminNoticeDao.noticeDetail(nvo);
		return detail;
	}

	
}
