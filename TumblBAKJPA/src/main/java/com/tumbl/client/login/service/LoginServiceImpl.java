/*package com.tumbl.client.login.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.client.login.dao.LoginDao;
import com.tumbl.client.login.vo.LoginVO;
import com.tumbl.client.member.dao.MemberDao;
import com.tumbl.client.member.vo.MemberSecurity;
import com.tumbl.common.util.OpenCrypt;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	Logger logger = Logger.getLogger(LoginServiceImpl.class);
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private MemberDao memberDao;

	@Override
	public LoginVO userIdSelect(String email) {
		return loginDao.userIdSelect(email);
	}

	@Override
	public LoginVO loginSelect(String email, String m_pw) {
		LoginVO vo = null;
		MemberSecurity sec = memberDao.securitySelect(email);
		if (sec != null) {
			m_pw = new String(OpenCrypt.getSHA256(m_pw, sec.getSalt()));
			LoginVO lvo = new LoginVO();
			lvo.setEmail(email);
			lvo.setM_pw(m_pw);
			
		    
			vo = loginDao.loginSelect(lvo);
		}
		return vo;
	}

	@Override
	public int loginHistoryInsert(LoginVO lvo) {
		int result;
		if (userIdSelect(lvo.getEmail()) == null) {
			result = 1;
		} else {
			LoginVO vo = loginHistorySelect(lvo.getEmail());
			if (vo == null) {
				loginDao.loginHistoryInsert(lvo);
			}
			result = 2;
		}
		return result;
	}

	@Override
	public int loginHistoryUpdate(LoginVO lvo) {
		return loginDao.loginHistoryUpdate(lvo);
	}

	@Override
	public LoginVO loginHistorySelect(String email) {
		return loginDao.loginHistorySelect(email);
	}
}*/