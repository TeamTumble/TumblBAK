package com.tumbl.client.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.client.member.vo.MemberSecurity;

public interface MemberSecurityRepository extends JpaRepository<MemberSecurity, String> {
	MemberSecurity findByEmail(String email);
}
