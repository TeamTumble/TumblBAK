package com.tumbl.client.notice.dao;

import java.util.List;

import com.tumbl.admin.notice.vo.NoticeVO;

public interface NoticeDao {
	public List<NoticeVO> noticeList(NoticeVO nvo);// 글 목록 구현

	public int noticeListCnt(NoticeVO nvo);// 전체 레코드 건수 구현


	public NoticeVO noticeDetail(NoticeVO nvo);// 글 상세 구현
	

}
