package com.tumbl.admin.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tumbl.admin.login.repository.AdminLoginRepository;
import com.tumbl.admin.login.vo.AdminLoginVO;

@Service
public class AdminLoginService {
	
	@Resource
	AdminLoginRepository adminLoginRepository;
	
	public AdminLoginVO AdminloginSelect(String adid, String adpw) {
		AdminLoginVO lVo = null;
		lVo = adminLoginRepository.findByAdidAndAdpw(adid, adpw);
		return lVo;
	}

}
