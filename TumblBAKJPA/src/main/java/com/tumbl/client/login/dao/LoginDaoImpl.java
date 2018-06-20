/*package com.tumbl.client.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.client.login.vo.LoginVO;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SqlSession session;

	@Override
	public LoginVO userIdSelect(String email) {
		return (LoginVO) session.selectOne("userIdSelect", email);
	}

	@Override
	public LoginVO loginSelect(LoginVO lvo) {
		return (LoginVO) session.selectOne("loginSelect", lvo);
	}

	@Override
	public int loginHistoryInsert(LoginVO lvo) {
		return session.insert("loginHistoryInsert", lvo);
	}

	@Override
	public int loginHistoryUpdate(LoginVO lvo) {
		return session.update("loginHistoryUpdate", lvo);
	}

	@Override
	public LoginVO loginHistorySelect(String email) {
		return (LoginVO) session.selectOne("loginHistorySelect", email);
	}
}*/