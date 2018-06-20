/*package com.tumbl.client.support.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.client.support.vo.SupportVO;

@Repository
public class SupportDAOImpl implements SupportDAO {

	@Autowired
	private SqlSession session;

	@Override
	public int supportInsert(SupportVO svo) {
		return session.insert("supportInsert", svo);
	}
	
	@Override
	public int supportInsertPlus(SupportVO svo) {
		return session.update("supportInsertPlus", svo);
	}

	@Override
	public SupportVO supportDetail(SupportVO svo) {
		return (SupportVO) session.selectOne("projectDetail", svo);
	}

	@Override
	public SupportVO supportSuccess(SupportVO svo) {
		return (SupportVO) session.selectOne("supportSuccess", svo);
	}

}
*/