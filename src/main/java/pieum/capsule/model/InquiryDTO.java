package pieum.capsule.model;

import java.sql.Timestamp;

public class InquiryDTO {

	
	// 1:1문의/공지
	private String mno;
	private String nno;
	private String ntitle;
	private String ncontent;
	private Timestamp nregdate;
	private String acontent;
	private String ntype;
	
	public InquiryDTO() {
		
	}

	public InquiryDTO(String mno, String nno, String ntitle, String ncontent, Timestamp nregdate, String acontent, String ntype) {
		super();
		this.mno = mno;
		this.nno = nno;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nregdate = nregdate;
		this.acontent = acontent;
		this.ntype = ntype;
	}
	
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getNno() {
		return nno;
	}
	public void setNno(String nno) {
		this.nno = nno;
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
	public Timestamp getNregdate() {
		return nregdate;
	}
	public void setNregdate(Timestamp nregdate) {
		this.nregdate = nregdate;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	
	public String getNtype() {
	    return ntype; 
	}
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}
	
	private String answer_status;
	
	public String getAnswer_status() {
		return answer_status;
	}
	
	public void setAnswer_status(String answer_status) {
		this.answer_status=answer_status;
	}
	
	
}
