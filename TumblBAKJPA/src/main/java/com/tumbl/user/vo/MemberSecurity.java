package com.tumbl.user.vo;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: MemberSecurity
 *
 */
@Entity

public class MemberSecurity  {

	@Id
	@GeneratedValue
	private String email;
	private String salt;

	public MemberSecurity() {
		super();
	}

	public MemberSecurity(String email, String salt) {
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
