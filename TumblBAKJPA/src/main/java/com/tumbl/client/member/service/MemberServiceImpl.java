/*package com.tumbl.client.member.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.client.member.dao.MemberDao;
import com.tumbl.client.member.vo.MemberSecurity;
import com.tumbl.client.member.vo.MemberVO;
import com.tumbl.client.project.vo.ProjectVO1;
import com.tumbl.client.support.vo.SupportVO;
import com.tumbl.common.util.OpenCrypt;
import com.tumbl.common.util.Util;


@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	Logger logger = Logger.getLogger(MemberServiceImpl.class);
	
	
	
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public int userIdConfirm(String email) {
		int result;
		if (memberDao.memberSelect(email) != null) {
			result = 1;
		} else {
			result = 2;
		}
		return result;
	}
	//회원틍록
	@Override
	public int memberInsert(MemberVO mvo) {
		int sCode = 2;
		if (memberDao.memberSelect(mvo.getEmail()) != null) {
			return 1;
		} else {
			try {
				//비밀번호 암호화
				MemberSecurity sec = new MemberSecurity();
				sec.setEmail(mvo.getEmail());
				sec.setSalt(Util.getRandomString());
				sCode = memberDao.securityInsert(sec);
				if (sCode == 1) {
					mvo.setM_pw(new String(OpenCrypt.getSHA256(mvo.getM_pw(), sec.getSalt())));
					memberDao.memberInsert(mvo);
					return 3;
				} else {
					return 2;
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
				return 2;
			}
		}
	}

	public MemberVO memberSelect(String email) {
		MemberVO vo = memberDao.memberSelect(email);
		return vo;
	}
	
	public boolean memberUpdate(MemberVO mvo) {
		try {
			if (!mvo.getM_pw().isEmpty()) {
				MemberSecurity sec = memberDao.securitySelect(mvo.getEmail());
				mvo.setM_pw(new String(OpenCrypt.getSHA256(mvo.getM_pw(), sec.getSalt())));
			}
			memberDao.memberUpdate(mvo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int memberDelete(String email) {
		int mCode, sCode, isSucessCode = 3;
		try {
			mCode = memberDao.memberDelete(email);
			if (mCode == 1) {
				sCode = memberDao.securityDelete(email);
				if (sCode == 1) {
					isSucessCode = 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSucessCode = 3;
		}
		return isSucessCode;
	}

	
	public List<ProjectVO1> projectMember(ProjectVO1 pvo) {
		List<ProjectVO1> myList = null;
		myList = memberDao.projectMember(pvo);
		return myList;
	}

	@Override
	public List<SupportVO> supportMember(SupportVO svo) {
		List<SupportVO> myList = null;
		myList = memberDao.supportMember(svo);
		return myList;
	}
	
}*/