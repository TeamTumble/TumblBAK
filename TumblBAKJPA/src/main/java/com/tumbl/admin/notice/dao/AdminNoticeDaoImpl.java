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

	// 글 목록 구현
	@Override
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		return session.selectList("noticeList", nvo);
	}

	// 전체 레코드 건수 구현
	@Override
	public int noticeListCnt(NoticeVO nvo) {
		return (Integer) session.selectOne("noticeListCnt");
	}

	// 글입력 구현
	@Override
	public int noticeInsert(NoticeVO nvo) {
		return session.insert("noticeInsert", nvo);
	}

	// 글 상세 구현
	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		return (NoticeVO) session.selectOne("noticeDetail", nvo);
	}

	// 글 수정 구현
	@Override
	public int noticeUpdate(NoticeVO nvo) {
		return session.update("noticeUpdate", nvo);
	}

	// 글 삭제구현
	@Override
	public int noticeDelete(int n_no) {
		return session.delete("noticeDelete", n_no);
	}

}
*/