package com.tumbl.client.member.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.client.member.vo.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	/*List<Member> findByemail(String email);*/
	Member findByemail(String email);
	
	Member findByEmailAndMpw(String email, String mpw);
	

	
	

}
