package com.tumbl.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tumbl.common.util.OpenCrypt;
import com.tumbl.common.util.Util;
import com.tumbl.user.repository.MemberRepository;
import com.tumbl.user.repository.MemberSecurityRepository;
import com.tumbl.user.repository.ProjectRepository;
import com.tumbl.user.repository.SupportRepository;
import com.tumbl.user.vo.Member;
import com.tumbl.user.vo.MemberSecurity;
import com.tumbl.user.vo.ProjectVO;
import com.tumbl.user.vo.SupportVO;

/**
 * User: HolyEyE Date: 2013. 12. 3. Time: 오전 1:07
 */
@Service
public class MemberService {

	@Resource
	MemberRepository memberRepository;

	@Resource
	MemberSecurityRepository memberSercurityRepository;

	@Resource
	ProjectRepository projectRepository;

	@Resource
	SupportRepository supportRepository;
	
	
	public int userIdConfirm(String email) {
		int result;
		if (memberRepository.findByemail(email) != null) {
			result = 1;
		} else {
			result = 2;
		}
		return result;
	}

	/**
	 * 회원 가입
	 */

	public void join(Member mvo) {

		// 비밀번호 암호화
		MemberSecurity sec = new MemberSecurity();
		sec.setEmail(mvo.getEmail());
		sec.setSalt(Util.getRandomString());
		memberSercurityRepository.save(sec);

		mvo.setMpw(new String(OpenCrypt.getSHA256(mvo.getMpw(), sec.getSalt())));
		memberRepository.save(mvo);

	}

	/**
	 * 전체 회원 조회
	 */

	public Member findOne(String email) {

		return memberRepository.findOne(email);
	}

	public Member findByemail(String email) {
		return memberRepository.findByemail(email);

	}

	public void memberUpdate(Member mvo) {
		try {
			if (!mvo.getMpw().isEmpty()) {
				MemberSecurity sec = memberSercurityRepository.findByEmail(mvo.getEmail());
				mvo.setMpw(new String(OpenCrypt.getSHA256(mvo.getMpw(), sec.getSalt())));
			}
			memberRepository.save(mvo);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public List<ProjectVO> projectMember(ProjectVO pvo) {
		List<ProjectVO> myList = null;
		myList = projectRepository.findByEmail(pvo.getEmail());
		return myList;
	}

	public List<SupportVO> supportMember(SupportVO svo) {
		List<SupportVO> myList = null;
		myList = supportRepository.findByEmail(svo.getEmail());
		return myList;
	}

	public Member findByEmailAndMpw(String email, String mpw) {
		return memberRepository.findByEmailAndMpw(email, mpw);
	}

	public void memberDelete(String email) {
		Member mvo = new Member();
		MemberSecurity mso = new MemberSecurity();
		mvo = memberRepository.findByemail(email);
		mso = memberSercurityRepository.findByEmail(email);

		memberRepository.delete(mvo);
		memberSercurityRepository.delete(mso);
	}

}
