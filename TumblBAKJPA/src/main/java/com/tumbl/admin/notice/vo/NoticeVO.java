package com.tumbl.admin.notice.vo;

import com.tumbl.admin.common.vo.CommonVO;

public class NoticeVO extends CommonVO {
	private int n_no = 0; // 글번호
	private int idx = 0;
	private String email = ""; // 작성자
	private String n_title = ""; // 제목
	private String n_content = ""; // 내용
	private String n_date = ""; // 작성일

	public NoticeVO() {
		super();
	}

	public NoticeVO(int n_no, int idx, String email, String n_title, String n_content, String n_date) {
		super();
		this.n_no = n_no;
		this.idx = idx;
		this.email = email;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_date = n_date;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
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

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public String getN_date() {
		return n_date;
	}

	public void setN_date(String n_date) {
		this.n_date = n_date;
	}

	@Override
	public String toString() {
		return "NoticeVO [n_no=" + n_no + ", idx=" + idx + ", email=" + email + ", n_title=" + n_title + ", n_content="
				+ n_content + ", n_date=" + n_date + ", getPage()=" + getPage() + ", getPageSize()=" + getPageSize()
				+ ", getStart_row()=" + getStart_row() + ", getEnd_row()=" + getEnd_row() + ", getSearch()="
				+ getSearch() + ", getKeyword()=" + getKeyword() + ", getOrder_by()=" + getOrder_by()
				+ ", getOrder_sc()=" + getOrder_sc() + ", getResult_cd()=" + getResult_cd() + ", getResult_msg()="
				+ getResult_msg() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
