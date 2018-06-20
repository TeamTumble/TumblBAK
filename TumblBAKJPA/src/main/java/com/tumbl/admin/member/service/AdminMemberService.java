package com.tumbl.admin.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tumbl.client.member.repository.MemberRepository;
import com.tumbl.client.member.vo.Member;

@Service
public class AdminMemberService {
	
	@Resource
	MemberRepository memberRepository;
	
	public List<Member> memberList(Member mvo) {
		
		 
		return memberRepository.findAll();
	}

}
