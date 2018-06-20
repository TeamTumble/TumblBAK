/*package com.tumbl.admin.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.admin.login.vo.AdminLoginVO;

@Repository
public class AdminLoginDaoImpl implements AdminLoginDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public AdminLoginVO AdminloginSelect(AdminLoginVO lvo) {
		return (AdminLoginVO)session.selectOne("AdminloginSelect",lvo);
	}

}
*/