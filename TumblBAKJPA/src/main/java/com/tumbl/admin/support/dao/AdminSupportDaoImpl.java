/*package com.tumbl.admin.support.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.client.support.vo.SupportVO;

@Repository
public class AdminSupportDaoImpl implements AdminSupportDao {
	@Autowired
	private SqlSession session;

	// 글 목록 구현
	@Override
	public List<SupportVO> supportList(SupportVO svo) {
		return session.selectList("supportList", svo);
	}

	// 전체 레코드 건수 구현
	@Override
	public int supportListCnt(SupportVO svo) {
		return (Integer) session.selectOne("supportListCnt");
	}

	// 글입력 구현
	@Override
	public int supportInsert(SupportVO svo) {
		return session.insert("supportInsert", svo);
	}

	// 글 상세 구현
	@Override
	public SupportVO supportDetail(SupportVO svo) {
		return (SupportVO) session.selectOne("supportDetail", svo);
	}

	// 글 수정 구현
	@Override
	public int supportUpdate(SupportVO svo) {
		return session.update("supportUpdate", svo);
	}

	// 글 삭제구현
	@Override
	public int supportDelete(int s_no) {
		return session.delete("supportDelete", s_no);
	}

}
*/