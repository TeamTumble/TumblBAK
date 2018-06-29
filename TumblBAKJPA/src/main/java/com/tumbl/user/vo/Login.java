package com.tumbl.user.vo;



import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Login
 *
 */
@Entity
public class Login  {
	
	@Id
	private String email = "";
	private String mpw = "";
	private String m_name = "";

	public Login() {
		super();
	}

	public Login(String email, String mpw, String m_name) {
		super();
		this.email = email;
		this.mpw = mpw;
		this.m_name = m_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	@Override
	public String toString() {
		return "LoginVO [userId=" + email + ", userPw=" + mpw + ", userName=" + m_name + "]";
	}
   
}
