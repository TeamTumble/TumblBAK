package com.tumbl.user.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.tumbl.client.common.vo.CommonVO;

/**
 * Entity implementation class for Entity: ProjectVO
 *
 */
@Entity
@org.hibernate.annotations.DynamicUpdate
@Table(name="ProjectVO")
public class ProjectVO extends CommonVO{

	
	@Id
	@GeneratedValue
	private int pno;
	private String email;
	private String ptitle;
	private String p_image;
	private String p_type;
	private String p_summary;

	private String pm_image;
	private String pmname;
	private String pm_area;
	private String pm_intro;

	private int p_price;
	private String p_startdate;
	private int p_fundingdate;
	private String p_enddate;
	private String p_enddate_input;
	private String p_paydate;
	private String p_paydate_input;

	private int p_giftNo;
	private String p_giftname;
	private int p_giftprice;
	private int p_giftquantity;
	private String p_giftexplanation;
	private String p_giftdate;
	private String p_refund;
	private String p_delivery;
	
	@Lob
	private String p_story;
	
	private String p_storyimage;

	private String pm_email;
	private String pm_phone;
	private String pm_bank;
	private String pm_acountname;
	private String pm_acount;
	private String pm_birthday;

	private int p_okcheck = 1;
	private String pcase;// 프로젝트 상태(승인대기,승인,미승인)
	private String p_remarks;// 비고(승인 거절 사유)
	
	private int psupporter; // 후원자 집계
	private int pcollection; // 후원금액 집계
	private String p_thumbnail;

	
	@Transient
	private MultipartFile p_file;
	@Transient
	private MultipartFile pm_file;
	@Transient
	private MultipartFile ps_file;

	

	public ProjectVO() {
		super();
	}

	public ProjectVO(int pno, String email, String ptitle, String p_image, String p_type, String p_summary,
			String pm_image, String pmname, String pm_area, String pm_intro, int p_price, String p_startdate,
			int p_fundingdate, String p_enddate, String p_paydate, int p_giftNo, String p_giftname, int p_giftprice,
			int p_giftquantity, String p_giftexplanation, String p_giftdate, String p_refund, String p_delivery,
			String p_story, String p_storyimage, String pm_email, String pm_phone, String pm_bank, String pm_acountname,
			String pm_acount, String pm_birthday, int p_okcheck,String pcase, String p_remarks, MultipartFile p_file,
			MultipartFile pm_file, MultipartFile ps_file, int psupporter, int pcollection, String p_thumbnail) {
		super();
		this.pno = pno;
		this.email = email;
		this.ptitle = ptitle;
		this.p_image = p_image;
		this.p_type = p_type;
		this.p_summary = p_summary;
		this.pm_image = pm_image;
		this.pmname = pmname;
		this.pm_area = pm_area;
		this.pm_intro = pm_intro;
		this.p_price = p_price;
		this.p_startdate = p_startdate;
		this.p_fundingdate = p_fundingdate;
		this.p_enddate = p_enddate;
		this.p_paydate = p_paydate;
		this.p_giftNo = p_giftNo;
		this.p_giftname = p_giftname;
		this.p_giftprice = p_giftprice;
		this.p_giftquantity = p_giftquantity;
		this.p_giftexplanation = p_giftexplanation;
		this.p_giftdate = p_giftdate;
		this.p_refund = p_refund;
		this.p_delivery = p_delivery;
		this.p_story = p_story;
		this.p_storyimage = p_storyimage;
		this.pm_email = pm_email;
		this.pm_phone = pm_phone;
		this.pm_bank = pm_bank;
		this.pm_acountname = pm_acountname;
		this.pm_acount = pm_acount;
		this.pm_birthday = pm_birthday;
		this.p_okcheck = p_okcheck;
		this.pcase = pcase;
		this.p_remarks = p_remarks;
		this.p_file = p_file;
		this.pm_file = pm_file;
		this.ps_file = ps_file;
		this.psupporter = psupporter;
		this.pcollection = pcollection;
		this.p_thumbnail = p_thumbnail;
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

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getP_summary() {
		return p_summary;
	}

	public void setP_summary(String p_summary) {
		this.p_summary = p_summary;
	}

	public String getPm_image() {
		return pm_image;
	}

	public void setPm_image(String pm_image) {
		this.pm_image = pm_image;
	}

	public String getPmname() {
		return pmname;
	}

	public void setPmname(String pmname) {
		this.pmname = pmname;
	}

	public String getPm_area() {
		return pm_area;
	}

	public void setPm_area(String pm_area) {
		this.pm_area = pm_area;
	}

	public String getPm_intro() {
		return pm_intro;
	}

	public void setPm_intro(String pm_intro) {
		this.pm_intro = pm_intro;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_startdate() {
		return p_startdate;
	}

	public void setP_startdate(String p_startdate) {
		this.p_startdate = p_startdate;
	}

	public int getP_fundingdate() {
		return p_fundingdate;
	}

	public void setP_fundingdate(int p_fundingdate) {
		this.p_fundingdate = p_fundingdate;
	}

	public String getP_enddate() {
		return p_enddate;
	}

	public void setP_enddate(String p_enddate) {
		this.p_enddate = p_enddate;
	}

	public String getP_enddate_input() {
		return p_enddate_input;
	}

	public void setP_enddate_input(String p_enddate_input) {
		this.p_enddate_input = p_enddate_input;
	}

	public String getP_paydate_input() {
		return p_paydate_input;
	}

	public void setP_paydate_input(String p_paydate_input) {
		this.p_paydate_input = p_paydate_input;
	}

	public String getP_paydate() {
		return p_paydate;
	}

	public void setP_paydate(String p_paydate) {
		this.p_paydate = p_paydate;
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

	public int getP_giftquantity() {
		return p_giftquantity;
	}

	public void setP_giftquantity(int p_giftquantity) {
		this.p_giftquantity = p_giftquantity;
	}

	public String getP_giftexplanation() {
		return p_giftexplanation;
	}

	public void setP_giftexplanation(String p_giftexplanation) {
		this.p_giftexplanation = p_giftexplanation;
	}

	public String getP_giftdate() {
		return p_giftdate;
	}

	public void setP_giftdate(String p_giftdate) {
		this.p_giftdate = p_giftdate;
	}

	public String getP_refund() {
		return p_refund;
	}

	public void setP_refund(String p_refund) {
		this.p_refund = p_refund;
	}

	public String getP_delivery() {
		return p_delivery;
	}

	public void setP_delivery(String p_delivery) {
		this.p_delivery = p_delivery;
	}

	public String getP_story() {
		return p_story;
	}

	public void setP_story(String p_story) {
		this.p_story = p_story;
	}

	public String getP_storyimage() {
		return p_storyimage;
	}

	public void setP_storyimage(String p_storyimage) {
		this.p_storyimage = p_storyimage;
	}

	public String getPm_email() {
		return pm_email;
	}

	public void setPm_email(String pm_email) {
		this.pm_email = pm_email;
	}

	public String getPm_phone() {
		return pm_phone;
	}

	public void setPm_phone(String pm_phone) {
		this.pm_phone = pm_phone;
	}

	public String getPm_bank() {
		return pm_bank;
	}

	public void setPm_bank(String pm_bank) {
		this.pm_bank = pm_bank;
	}

	public String getPm_acountname() {
		return pm_acountname;
	}

	public void setPm_acountname(String pm_acountname) {
		this.pm_acountname = pm_acountname;
	}

	public String getPm_acount() {
		return pm_acount;
	}

	public void setPm_acount(String pm_acount) {
		this.pm_acount = pm_acount;
	}

	public String getPm_birthday() {
		return pm_birthday;
	}

	public void setPm_birthday(String pm_birthday) {
		this.pm_birthday = pm_birthday;
	}

	public int getP_okcheck() {
		return p_okcheck;
	}

	public void setP_okcheck(int p_okcheck) {
		this.p_okcheck = p_okcheck;
	}

	public String getP_remarks() {
		return p_remarks;
	}

	public void setP_remarks(String p_remarks) {
		this.p_remarks = p_remarks;
	}

	public MultipartFile getP_file() {
		return p_file;
	}
	
	

	public String getPcase() {
		return pcase;
	}

	public void setPcase(String pcase) {
		this.pcase = pcase;
	}

	public void setP_file(MultipartFile p_file) {
		this.p_file = p_file;
	}

	public MultipartFile getPm_file() {
		return pm_file;
	}

	public void setPm_file(MultipartFile pm_file) {
		this.pm_file = pm_file;
	}

	public MultipartFile getPs_file() {
		return ps_file;
	}

	public void setPs_file(MultipartFile ps_file) {
		this.ps_file = ps_file;
	}

	public int getPsupporter() {
		return psupporter;
	}

	public void setPsupporter(int psupporter) {
		this.psupporter = psupporter;
	}

	public int getPcollection() {
		return pcollection;
	}

	public void setPcollection(int pcollection) {
		this.pcollection = pcollection;
	}

	public String getP_thumbnail() {
		return p_thumbnail;
	}

	public void setP_thumbnail(String p_thumbnail) {
		this.p_thumbnail = p_thumbnail;
	}

	@Override
	public String toString() {
		return "ProjectVO [pno=" + pno + ", ptitle=" + ptitle + ", p_image=" + p_image + ", p_type=" + p_type
				+ ", p_summary=" + p_summary + ", pm_image=" + pm_image + ", pmname=" + pmname + ", pm_area="
				+ pm_area + ", pm_intro=" + pm_intro + ", p_price=" + p_price + ", p_startdate=" + p_startdate
				+ ", p_fundingdate=" + p_fundingdate + ", p_enddate=" + p_enddate + ", p_paydate=" + p_paydate
				+ ", p_giftNo=" + p_giftNo + ", p_giftname=" + p_giftname + ", p_giftprice=" + p_giftprice
				+ ", p_giftquantity=" + p_giftquantity + ", p_giftexplanation=" + p_giftexplanation + ", p_giftdate="
				+ p_giftdate + ", p_refund=" + p_refund + ", p_delivery=" + p_delivery + ", p_story=" + p_story
				+ ", p_storyimage=" + p_storyimage + ", pm_email=" + pm_email + ", pm_phone=" + pm_phone + ", pm_bank="
				+ pm_bank + ", pm_acountname=" + pm_acountname + ", pm_acount=" + pm_acount + ", pm_birthday="
				+ pm_birthday + ", p_okcheck=" + p_okcheck + ", p_case="+ pcase + ", p_remark=" + p_remarks + /*", p_file=" + p_file
				+ ", pm_file=" + pm_file + ", ps_file=" + ps_file +*/ "]";
	}

   
}
