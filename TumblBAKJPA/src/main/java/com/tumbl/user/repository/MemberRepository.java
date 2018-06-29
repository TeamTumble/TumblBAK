package com.tumbl.user.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.user.vo.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	/*List<Member> findByemail(String email);*/
	Member findByemail(String email);
	
	Member findByEmailAndMpw(String email, String mpw);
	
	Page<Member> findByEmailContaining(String email, Pageable pageable);

	Page<Member> findByMnameContaining(String mname, Pageable pageable);
	

	
	

}
