package com.tumbl.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tumbl.admin.vo.AdminLoginVO;

public interface AdminLoginRepository extends JpaRepository<AdminLoginVO, String> {
	
	AdminLoginVO findByAdidAndAdpw(String adid, String adpw);

}
