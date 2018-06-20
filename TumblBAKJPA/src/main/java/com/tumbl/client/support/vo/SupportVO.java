package com.tumbl.client.support.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SupportVO  {
	@Id
	@GeneratedValue
	private int s_no; // 후원번호
	
	private int pno; // 프로젝트 번호 (외부 키)
	private String email; // 회원 아이디(외부데이터 로드용)
	private String p_title; // 프로젝트 제목(외부데이터 로드용)

	// 배송지 입력
	private String s_name; // 후원인 이름
	private String s_zipcode; // 후원인 우편번호
	private String s_address; // 후원인 주소
	private String s_email; // 후원인 이메일
	private String s_phone; // 후원인 폰

	// 후원 내역
	private String s_giftname; // 후원상품 명
	private int s_giftquantity; // 후원 상품 개수
	private int s_giftprice; // 후원 상품 가격
	private int s_addprice; // 상품외 후원 금액
	private int s_price; // 총 후원금액

	// 결제 내역
	private String s_paymenttype; // 결제 타입
	private String s_bank; // 후원 은행
	private String s_account; // 후원 계좌
	private String s_date; // 후원일자

	// 약관 체크
	private String s_paymentcheck; // 결제확인
	private int s_supporter; // 후원자 값(후원자 수 추가용)

	private int p_giftNo; // 리워드 번호 (외부데이터 로드용)
	private String p_giftname; // 리워드 명(외부데이터 로드용)
	private int p_giftprice; // 리워드 가격(외부데이터 로드용)

	public SupportVO() {
		super();
	}

	public SupportVO(int s_no, int pno, String email, String p_title, String s_name, String s_zipcode,
			String s_address, String s_email, String s_phone, String s_giftname, int s_giftquantity, int s_giftprice,
			int s_addprice, int s_price, String s_paymenttype, String s_bank, String s_account, String s_date,
			String s_paymentcheck, int s_supporter, int p_giftNo, String p_giftname, int p_giftprice) {
		super();
		this.s_no = s_no;
		this.pno = pno;
		this.email = email;
		this.p_title = p_title;
		this.s_name = s_name;
		this.s_zipcode = s_zipcode;
		this.s_address = s_address;
		this.s_email = s_email;
		this.s_phone = s_phone;
		this.s_giftname = s_giftname;
		this.s_giftquantity = s_giftquantity;
		this.s_giftprice = s_giftprice;
		this.s_addprice = s_addprice;
		this.s_price = s_price;
		this.s_paymenttype = s_paymenttype;
		this.s_bank = s_bank;
		this.s_account = s_account;
		this.s_date = s_date;
		this.s_paymentcheck = s_paymentcheck;
		this.s_supporter = s_supporter;
		this.p_giftNo = p_giftNo;
		this.p_giftname = p_giftname;
		this.p_giftprice = p_giftprice;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_zipcode() {
		return s_zipcode;
	}

	public void setS_zipcode(String s_zipcode) {
		this.s_zipcode = s_zipcode;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public String getS_phone() {
		return s_phone;
	}

	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}

	public String getS_giftname() {
		return s_giftname;
	}

	public void setS_giftname(String s_giftname) {
		this.s_giftname = s_giftname;
	}

	public int getS_giftquantity() {
		return s_giftquantity;
	}

	public void setS_giftquantity(int s_giftquantity) {
		this.s_giftquantity = s_giftquantity;
	}

	public int getS_giftprice() {
		return s_giftprice;
	}

	public void setS_giftprice(int s_giftprice) {
		this.s_giftprice = s_giftprice;
	}

	public int getS_addprice() {
		return s_addprice;
	}

	public void setS_addprice(int s_addprice) {
		this.s_addprice = s_addprice;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	public String getS_paymenttype() {
		return s_paymenttype;
	}

	public void setS_paymenttype(String s_paymenttype) {
		this.s_paymenttype = s_paymenttype;
	}

	public String getS_bank() {
		return s_bank;
	}

	public void setS_bank(String s_bank) {
		this.s_bank = s_bank;
	}

	public String getS_account() {
		return s_account;
	}

	public void setS_account(String s_account) {
		this.s_account = s_account;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getS_paymentcheck() {
		return s_paymentcheck;
	}

	public void setS_paymentcheck(String s_paymentcheck) {
		this.s_paymentcheck = s_paymentcheck;
	}

	public int getS_supporter() {
		return s_supporter;
	}

	public void setS_supporter(int s_supporter) {
		this.s_supporter = s_supporter;
	}

	public int getP_giftNo() {
		return p_giftNo;
	}

	public void setP_giftNo(int p_giftNo) {
		this.p_giftNo = p_giftNo;
	}

	public String getP_giftname() {
		return p_giftname;
	}

	public void setP_giftname(String p_giftname) {
		this.p_giftname = p_giftname;
	}

	public int getP_giftprice() {
		return p_giftprice;
	}

	public void setP_giftprice(int p_giftprice) {
		this.p_giftprice = p_giftprice;
	}

	/*@Override
	public String toString() {
		return "SupportVO [s_no=" + s_no + ", Pno=" + Pno + ", email=" + email + ", p_title=" + p_title + ", s_name="
				+ s_name + ", s_zipcode=" + s_zipcode + ", s_address=" + s_address + ", s_email=" + s_email
				+ ", s_phone=" + s_phone + ", s_giftname=" + s_giftname + ", s_giftquantity=" + s_giftquantity
				+ ", s_giftprice=" + s_giftprice + ", s_addprice=" + s_addprice + ", s_price=" + s_price
				+ ", s_paymenttype=" + s_paymenttype + ", s_bank=" + s_bank + ", s_account=" + s_account + ", s_date="
				+ s_date + ", s_paymentcheck=" + s_paymentcheck + ", s_supporter=" + s_supporter + ", p_giftNo="
				+ p_giftNo + ", p_giftname=" + p_giftname + ", p_giftprice=" + p_giftprice + 
				+ ", toString()=" + super.toString() + "]";
	}*/

}
