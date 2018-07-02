package com.tumbl.admin.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tumbl.admin.common.vo.CommonVO;

@Entity
public class NoticeVO extends CommonVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nno = 0; // 글번호
	private int idx = 0;
	private String email = ""; // 작성자
	private String ntitle = ""; // 제목
	private String ncontent = ""; // 내용
	private String ndate = ""; // 작성일

	public NoticeVO() {
		super();
	}

	public NoticeVO(int nno, int idx, String email, String ntitle, String ncontent, String ndate) {
		super();
		this.nno = nno;
		this.idx = idx;
		this.email = email;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ndate = ndate;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNdate() {
		return ndate;
	}

	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

	@Override
	public String toString() {
		return "NoticeVO [nno=" + nno + ", idx=" + idx + ", email=" + email + ", ntitle=" + ntitle + ", ncontent="
				+ ncontent + ", ndate=" + ndate + "]";
	}

	
}
