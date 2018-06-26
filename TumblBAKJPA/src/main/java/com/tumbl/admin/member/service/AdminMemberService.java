package com.tumbl.admin.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.client.member.repository.MemberRepository;
import com.tumbl.client.member.vo.Member;
import com.tumbl.client.qna.vo.QnaVO;

@Service
public class AdminMemberService {
	
	@Resource
	MemberRepository memberRepository;
	
	//멤버 리스트 구현
	public List<Member> memberList(Member mvo) {
		return memberRepository.findAll();
	}
	

	public long countadminMember(Member mvo) {
		List<Member> myList = null;

		myList = memberRepository.findAll();
		long gg = memberRepository.count();

		return gg;

	}

	public Page<Member> findAll(Pageable pageable) {
		return memberRepository.findAll(pageable);
	}
	
	public Page<Member> findByEmailContaining(String email, PageRequest pageRequest) {

		return memberRepository.findByEmailContaining(email,pageRequest);
	}
	
	public Page<Member> findByMnameContaining(String mname, PageRequest pageRequest) {

		return memberRepository.findByMnameContaining(mname,pageRequest);
	}
	

}
