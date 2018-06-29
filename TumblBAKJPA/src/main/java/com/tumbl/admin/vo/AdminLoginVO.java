package com.tumbl.admin.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class AdminLoginVO {
	@Id
	private String adid;// ������ ���̵�
	private String adpw;// ������ ��й�ȣ
	private String adname;// ������ �̸�

	public AdminLoginVO() {
		super();
	}

	public AdminLoginVO(String adid, String adpw, String adname) {
		super();
		this.adid = adid;
		this.adpw = adpw;
		this.adname = adname;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getAdpw() {
		return adpw;
	}

	public void setAdpw(String adpw) {
		this.adpw = adpw;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	@Override
	public String toString() {
		return "loginVO [adid=" + adid + ", adpw=" + adpw + ", adname=" + adname + "]";
	}

}
