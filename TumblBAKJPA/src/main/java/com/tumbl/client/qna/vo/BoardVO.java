package com.tumbl.client.qna.vo;

import org.springframework.web.multipart.MultipartFile;

import com.tumbl.client.common.vo.CommonVO;

public class BoardVO extends CommonVO{
	private int q_num = 0; // 글번호
	private int idx = 0;
	private String email = ""; // 작성자
	private String q_title = ""; // 제목
	private String q_content = ""; // 내용
	private String q_date = ""; // 작성일
	
	
	// 파일 업로드를 위한 속성

	private MultipartFile file; //첨부파일
	private String b_file=""; // 실제서버에 저장한 파일명
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
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
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_date() {
		return q_date;
	}
	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getB_file() {
		return b_file;
	}
	public void setB_file(String b_file) {
		this.b_file = b_file;
	}
	
	
	
	
	
}