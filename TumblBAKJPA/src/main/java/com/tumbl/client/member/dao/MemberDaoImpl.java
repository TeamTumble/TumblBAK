/*package com.tumbl.client.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.client.member.vo.MemberSecurity;
import com.tumbl.client.member.vo.MemberVO;
import com.tumbl.client.project.vo.ProjectVO1;
import com.tumbl.client.support.vo.SupportVO;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession session;

	@Override
	public int securityInsert(MemberSecurity set) {
		return session.insert("securityInsert", set);
	}

	@Override
	public MemberSecurity securitySelect(String email) {
		return (MemberSecurity) session.selectOne("securitySelect", email);
	}

	@Override
	public int securityDelete(String email) {
		return session.delete("securityDelete", email);
	}

	@Override
	public MemberVO memberSelect(String email) {
		return (MemberVO) session.selectList("memberSelect", email);
	}

	@Override
	public int memberInsert(MemberVO mvo) {
		return session.insert("memberInsert");
	}

	@Override
	public int memberUpdate(MemberVO mvo) {
		return session.update("memberUpdate", mvo);
	}

	@Override
	public int memberDelete(String email) {
		return session.delete("memberDelete", email);

	}

	@Override
	public List<ProjectVO1> projectMember(ProjectVO1 pvo) {
		return  session.selectList("projectMember", pvo);
	}

	@Override
	public List<SupportVO> supportMember(SupportVO svo) {
		return session.selectList("supportMember", svo);
	}
	
	

}
*/