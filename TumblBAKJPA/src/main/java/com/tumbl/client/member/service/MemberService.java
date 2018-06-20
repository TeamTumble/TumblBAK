package com.tumbl.client.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tumbl.client.member.repository.MemberRepository;
import com.tumbl.client.member.repository.MemberSecurityRepository;
import com.tumbl.client.member.vo.Member;
import com.tumbl.client.member.vo.MemberSecurity;
import com.tumbl.client.project.repository.ProjectRepository;
import com.tumbl.client.project.vo.ProjectVO;
import com.tumbl.client.support.repository.SupportRepository;
import com.tumbl.client.support.vo.SupportVO;
import com.tumbl.common.util.OpenCrypt;
import com.tumbl.common.util.Util;

/**
 * User: HolyEyE Date: 2013. 12. 3. Time: ���� 1:07
 */
@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	MemberSecurityRepository memberSercurityRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	SupportRepository supportRepository;

	/**
	 * ȸ�� ����
	 */

	public void join(Member mvo) {
		
		

	
		// ��й�ȣ ��ȣȭ
		MemberSecurity sec = new MemberSecurity();
		sec.setEmail(mvo.getEmail());
		sec.setSalt(Util.getRandomString());
		memberSercurityRepository.save(sec);

		mvo.setMpw(new String(OpenCrypt.getSHA256(mvo.getMpw(), sec.getSalt())));
		memberRepository.save(mvo);

	}

	
	/**
	 * ��ü ȸ�� ��ȸ
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
