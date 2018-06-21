package com.tumbl.client.login.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.client.login.repository.LoginHistoryRepository;
import com.tumbl.client.login.repository.LoginRepository;
import com.tumbl.client.login.vo.Login;
import com.tumbl.client.login.vo.LoginHistory;
import com.tumbl.client.login.vo.LoginVO;
import com.tumbl.client.member.repository.MemberRepository;
import com.tumbl.client.member.repository.MemberSecurityRepository;
import com.tumbl.client.member.vo.Member;
import com.tumbl.client.member.vo.MemberSecurity;
import com.tumbl.common.util.OpenCrypt;

@Service
public class LoginService {

	@Resource
	LoginRepository loginRepository;
	@Resource
	MemberRepository memberRepository;
	@Resource
	MemberSecurityRepository memberSecurityRepository;
	@Resource
	LoginHistoryRepository loginHistoryRepository;

	public Login userIdSelect(String email) {
		return loginRepository.findOne(email);
	}

	public Login loginSelect(String email, String mpw) {
		Login vo = new Login();
		Member vo1 = new Member();
		
		
		
		MemberSecurity sec = memberSecurityRepository.findOne(email);
		mpw = new String(OpenCrypt.getSHA256(mpw, sec.getSalt()));

		Login lvo = new Login();
		lvo.setEmail(email);
		lvo.setMpw(mpw);
		System.out.println(email + "   " + mpw);
		
		
		
		vo1 = memberRepository.findByEmailAndMpw(email,mpw);
		
		
		

		vo.setEmail(vo1.getEmail());
		vo.setMpw(vo1.getMpw());
		

		return vo;
	}

	public void loginHistoryInsert(LoginHistory lvo) {
		

		loginHistoryRepository.save(lvo);

		

		
	}

	public LoginHistory loginHistorySelect(String email) {
		return loginHistoryRepository.findOne(email);
	}

}
