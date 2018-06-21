package com.tumbl.client.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.admin.notice.vo.NoticeVO;
import com.tumbl.client.qna.vo.QnaVO;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private SqlSession session;

	// �� ��� ����
	@Override
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		return session.selectList("noticeList", nvo);
	}

	// ��ü ���ڵ� �Ǽ� ����
	@Override
	public int noticeListCnt(NoticeVO nvo) {
		return (Integer) session.selectOne("noticeListCnt");
	}

	// �� �� ����
	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		return (NoticeVO) session.selectOne("noticeDetail", nvo);
	}

}
