/*package com.tumbl.admin.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.admin.notice.vo.NoticeVO;

@Repository
public class AdminNoticeDaoImpl implements AdminNoticeDao {
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

	// ���Է� ����
	@Override
	public int noticeInsert(NoticeVO nvo) {
		return session.insert("noticeInsert", nvo);
	}

	// �� �� ����
	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		return (NoticeVO) session.selectOne("noticeDetail", nvo);
	}

	// �� ���� ����
	@Override
	public int noticeUpdate(NoticeVO nvo) {
		return session.update("noticeUpdate", nvo);
	}

	// �� ��������
	@Override
	public int noticeDelete(int n_no) {
		return session.delete("noticeDelete", n_no);
	}

}
*/