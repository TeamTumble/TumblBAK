package com.tumbl.client.member.vo;

public class MemberSecurity1 {

	private String email;
	private String salt;

	public MemberSecurity1() {
		super();
	}

	public MemberSecurity1(String email, String salt) {
		super();
		this.email = email;
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "MemberSecurity [email=" + email + ", salt=" + salt + "]";
	}

	
}
