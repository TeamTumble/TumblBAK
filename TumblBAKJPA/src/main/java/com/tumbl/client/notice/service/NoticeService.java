package com.tumbl.client.notice.service;

import java.util.List;

import com.tumbl.admin.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> noticeList(NoticeVO nvo);// �۸�� ����

	public int noticeListCnt(NoticeVO nvo); // ��ü ���ڵ� �� ����

	

	public NoticeVO noticeDetail(NoticeVO nvo);// �ۻ� ����

	
}
