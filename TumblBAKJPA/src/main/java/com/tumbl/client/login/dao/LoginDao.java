package com.tumbl.client.login.dao;

import com.tumbl.client.login.vo.LoginVO;

public interface LoginDao {
	public LoginVO userIdSelect(String email);

	public LoginVO loginSelect(LoginVO lvo);

	public int loginHistoryInsert(LoginVO lvo);

	public int loginHistoryUpdate(LoginVO lvo);

	public LoginVO loginHistorySelect(String email);

}
