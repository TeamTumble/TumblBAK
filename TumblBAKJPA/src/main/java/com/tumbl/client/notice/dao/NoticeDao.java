package com.tumbl.client.notice.dao;

import java.util.List;

import com.tumbl.admin.notice.vo.NoticeVO;

public interface NoticeDao {
	public List<NoticeVO> noticeList(NoticeVO nvo);// �� ��� ����

	public int noticeListCnt(NoticeVO nvo);// ��ü ���ڵ� �Ǽ� ����


	public NoticeVO noticeDetail(NoticeVO nvo);// �� �� ����
	

}
