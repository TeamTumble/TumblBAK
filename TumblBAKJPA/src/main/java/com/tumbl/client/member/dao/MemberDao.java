/*package com.tumbl.client.member.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.tumbl.client.member.vo.Member;
import com.tumbl.client.member.vo.MemberSecurity;

public class MemberDao {
	
	@Autowired
	private EntityManager em;
	public int securityInsert(MemberSecurity set);

	public MemberSecurity securitySelect(String email);

	public int securityDelete(String email);

	public Member memberSelect(String email) {
		
	}

	public void memberInsert(Member mvo) {
		
		System.out.println("dao Å¸³Ä?  " + mvo);
		em.persist(mvo);
	}

	public int memberUpdate(Member mvo) {
		
	}

	public int memberDelete(String email) {
		
	}
	
	
	public ProjectVO projectMember(String email);
	
	public List<ProjectVO1> projectMember(ProjectVO1 pvo);
	
	public List<SupportVO> supportMember(SupportVO svo);
	
	
	
	
}*/