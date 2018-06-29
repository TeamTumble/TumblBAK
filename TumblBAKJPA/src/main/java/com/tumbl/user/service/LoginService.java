package com.tumbl.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tumbl.common.util.OpenCrypt;
import com.tumbl.user.repository.LoginHistoryRepository;
import com.tumbl.user.repository.LoginRepository;
import com.tumbl.user.repository.MemberRepository;
import com.tumbl.user.repository.MemberSecurityRepository;
import com.tumbl.user.vo.Login;
import com.tumbl.user.vo.LoginHistory;
import com.tumbl.user.vo.Member;
import com.tumbl.user.vo.MemberSecurity;

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
