package com.tumbl.client.qna.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.tumbl.client.common.vo.CommonVO;

@Entity
public class QnaVO extends CommonVO{
	@Id
	@GeneratedValue
	private long qnum = 0; // 글번호
	private int idx = 0; //회원번호
	private String email = ""; // 작성자
	private String q_title = ""; // 제목
	private String q_content = ""; // 내용
	private String  q_date; // 작성일
	
	  // 댓글수를 위한 속성 
	private int r_cnt = 0;  
	 
	@Transient
	private MultipartFile file; //첨부파일
	
	private String b_file=""; // 실제서버에 저장한 파일명
	
	
	
	
	public QnaVO() {
		super();
	}
	public long getQnum() {
		return qnum;
	}
	public void setQnum(long qnum) {
		this.qnum = qnum;
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
	public int getR_cnt() {
		return r_cnt;
	}
	public void setR_cnt(int r_cnt) {
		this.r_cnt = r_cnt;
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
	@Override
	public String toString() {
		return "QnaVO [qnum=" + qnum + ", idx=" + idx + ", email=" + email + ", q_title=" + q_title + ", q_content="
				+ q_content + ", q_date=" + q_date + ", r_cnt=" + r_cnt + ", file=" + file + ", b_file=" + b_file
				+ ", getPage()=" + getPage() + ", getPageSize()=" + getPageSize() + ", getStart_row()=" + getStart_row()
				+ ", getEnd_row()=" + getEnd_row() + ", getSearch()=" + getSearch() + ", getKeyword()=" + getKeyword()
				+ ", getOrder_by()=" + getOrder_by() + ", getOrder_sc()=" + getOrder_sc() + ", getResult_cd()="
				+ getResult_cd() + ", getResult_msg()=" + getResult_msg() + ", getStart_date()=" + getStart_date()
				+ ", getEnd_date()=" + getEnd_date() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}