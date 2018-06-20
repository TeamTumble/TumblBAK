/*package com.tumbl.admin.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.admin.member.dao.AdminMemberDao;
import com.tumbl.client.member.vo.MemberVO;

@Service
@Transactional
public class AdminMemberServiceImpl implements AdminMemberService1 {
	@Autowired
	private AdminMemberDao adminMemberDao;

	@Override
	public List<MemberVO> memberList(MemberVO mvo) {
		List<MemberVO> mList = null;
		mList = adminMemberDao.memberList(mvo);
		return mList;
	}

	@Override
	public Map<String, Integer> memberAgeList() {
		Map<String, Integer> ageList = null;
		ageList = adminMemberDao.memberAgeList();
		return ageList;
	}

	@Override
	public Map<String, Integer> memberGenderList() {
		Map<String, Integer> genderList = null;
		genderList = adminMemberDao.memberGenderList();
		return genderList;
	}

}
*/