package com.tumbl.client.login.vo;

public class LoginVO extends LoginHistory1{
	private String email = "";
	private String m_pw = "";
	private String m_name = "";

	public LoginVO() {
		super();
	}

	public LoginVO(String email, String m_pw, String m_name) {
		super();
		this.email = email;
		this.m_pw = m_pw;
		this.m_name = m_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	@Override
	public String toString() {
		return "LoginVO [userId=" + email + ", userPw=" + m_pw + ", userName=" + m_name + ", getIdx()=" + getIdx()
				+ ", getRetry()=" + getRetry() + ", getLastFailedLogin()=" + getLastFailedLogin()
				+ ", getLastSuccessedLogin()=" + getLastSuccessedLogin() + ", getClientIP()=" + getClientIP() + "]";
	}

}
