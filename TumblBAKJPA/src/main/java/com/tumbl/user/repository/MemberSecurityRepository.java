package com.tumbl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.user.vo.MemberSecurity;

public interface MemberSecurityRepository extends JpaRepository<MemberSecurity, String> {
	MemberSecurity findByEmail(String email);
}
