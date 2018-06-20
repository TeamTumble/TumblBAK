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

	// �� ��� ����
	@Override
	public List<SupportVO> supportList(SupportVO svo) {
		return session.selectList("supportList", svo);
	}

	// ��ü ���ڵ� �Ǽ� ����
	@Override
	public int supportListCnt(SupportVO svo) {
		return (Integer) session.selectOne("supportListCnt");
	}

	// ���Է� ����
	@Override
	public int supportInsert(SupportVO svo) {
		return session.insert("supportInsert", svo);
	}

	// �� �� ����
	@Override
	public SupportVO supportDetail(SupportVO svo) {
		return (SupportVO) session.selectOne("supportDetail", svo);
	}

	// �� ���� ����
	@Override
	public int supportUpdate(SupportVO svo) {
		return session.update("supportUpdate", svo);
	}

	// �� ��������
	@Override
	public int supportDelete(int s_no) {
		return session.delete("supportDelete", s_no);
	}

}
*/