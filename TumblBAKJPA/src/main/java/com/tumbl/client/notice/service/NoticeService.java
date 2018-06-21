package com.tumbl.client.notice.service;

import java.util.List;

import com.tumbl.admin.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> noticeList(NoticeVO nvo);// 글목록 구현

	public int noticeListCnt(NoticeVO nvo); // 전체 레코드 수 구현

	

	public NoticeVO noticeDetail(NoticeVO nvo);// 글상세 구현

	
}
