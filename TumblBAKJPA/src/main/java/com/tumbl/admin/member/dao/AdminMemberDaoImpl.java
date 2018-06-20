/*package com.tumbl.admin.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.client.member.vo.MemberVO;

@Repository
public class AdminMemberDaoImpl implements AdminMemberDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<MemberVO> memberList(MemberVO mvo) {
		return session.selectList("memberList");
	}

	@Override
	public Map<String, Integer> memberAgeList() {
		return session.selectMap("memberAgeList", "");
	}

	@Override
	public Map<String, Integer> memberGenderList() {
		return session.selectMap("memberGenderList", "");
	}
}*/