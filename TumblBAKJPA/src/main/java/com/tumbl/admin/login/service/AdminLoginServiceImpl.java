/*package com.tumbl.admin.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.admin.login.dao.AdminLoginDao;
import com.tumbl.admin.login.vo.AdminLoginVO;

@Service
@Transactional
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	private AdminLoginDao adminLoginDao;

	@Override
	public AdminLoginVO AdminloginSelect(AdminLoginVO lvo) {
		AdminLoginVO lVo = null;
		lVo = adminLoginDao.AdminloginSelect(lvo);
		return lVo;
	}

}
*/