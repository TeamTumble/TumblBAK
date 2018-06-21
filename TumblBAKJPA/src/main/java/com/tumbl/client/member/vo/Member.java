package com.tumbl.client.member.vo;

import javax.persistence.*;

import com.sun.jmx.snmp.Timestamp;
import com.tumbl.client.common.vo.CommonVO;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity
@Table(name="member")
public class Member extends CommonVO {

	@Id
	@GeneratedValue
	private int idx;
	@Column(name="email" , unique=true)
	private String email;
	private String mpw;
	private String m_name;
	private String m_phone;
	private String m_status;
	private Timestamp m_joindate;
	@Transient
	private String oldm_pw;
	
	public Member() {
		super();
	}


	public Member(int idx, String email, String mpw, String m_name, String m_phone, String m_status,
			Timestamp m_joindate) {
		super();
		this.idx = idx;
		this.email = email;
		this.mpw = mpw;
		this.m_name = m_name;
		this.m_phone = m_phone;
		this.m_status = m_status;
		this.m_joindate = m_joindate;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String m_id) {
		this.email = m_id;
	}


	public String getMpw() {
		return mpw;
	}


	public void setMpw(String m_pw) {
		this.mpw = m_pw;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public String getM_phone() {
		return m_phone;
	}


	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}


	public String getM_status() {
		return m_status;
	}


	public void setM_status(String m_status) {
		this.m_status = m_status;
	}


	public Timestamp getM_joindate() {
		return m_joindate;
	}


	public void setM_joindate(Timestamp m_joindate) {
		this.m_joindate = m_joindate;
	}

	
	
	public String getOldm_pw() {
		return oldm_pw;
	}


	public void setOldm_pw(String oldm_pw) {
		this.oldm_pw = oldm_pw;
	}


	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", email=" + email + ", m_pw=" + mpw + ", m_name=" + m_name + ", m_phone="
				+ m_phone +  "]";
	}
	
   
}
