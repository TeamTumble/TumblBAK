package com.tumbl.admin.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.admin.login.vo.AdminLoginVO;

public interface AdminLoginRepository extends JpaRepository<AdminLoginVO, String> {
	
	AdminLoginVO findByAdidAndAdpw(String adid, String adpw);

}
