package com.tumbl.user.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReplyVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rnum = 0; // 댓글번호
	private int qnum = 0; // 게시판 글번호
	private String r_name = ""; // 댓글 작성자
	private String r_content = ""; // 댓글 내용
	private String r_date = ""; // 댓글 작성일
	private String r_pwd = ""; // 댓글 비밀번호

	public ReplyVO() {
		super();
	}

	public ReplyVO(int rnum, int qnum, String r_name, String r_content, String r_date, String r_pwd) {
		super();
		this.rnum = rnum;
		this.qnum = qnum;
		this.r_name = r_name;
		this.r_content = r_content;
		this.r_date = r_date;
		this.r_pwd = r_pwd;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getqnum() {
		return qnum;
	}

	public void setqnum(int qnum) {
		this.qnum = qnum;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public String getR_pwd() {
		return r_pwd;
	}

	public void setR_pwd(String r_pwd) {
		this.r_pwd = r_pwd;
	}

	@Override
	public String toString() {
		return "ReplyVO [r_num=" + rnum + ", qnum=" + qnum + ", r_name=" + r_name + ", r_content=" + r_content
				+ ", r_date=" + r_date + ", r_pwd=" + r_pwd + "]";
	}
}
