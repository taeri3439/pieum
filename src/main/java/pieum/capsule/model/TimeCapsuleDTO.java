package pieum.capsule.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class TimeCapsuleDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// 타임캡슐
	private String tcno;
	private String tcRegdate;
	private Timestamp openDate;
	private String tcTitle;
	private String tcContent;
	private char privates;
	private int viewCt;
	private String gno; // 그룹번호
	private String mno; // 사용자번호
	
	public TimeCapsuleDTO() {
		// TODO Auto-generated constructor stub
	}

	public TimeCapsuleDTO(String tcno, String tcRegdate, Timestamp openDate, String tcTitle, String tcContent,
			char privates, int viewCt, String gno, String mno) {
		super();
		this.tcno = tcno;
		this.tcRegdate = tcRegdate;
		this.openDate = openDate;
		this.tcTitle = tcTitle;
		this.tcContent = tcContent;
		this.privates = privates;
		this.viewCt = viewCt;
		this.gno = gno;
		this.mno = mno;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getTcRegdate() {
		return tcRegdate;
	}

	public void setTcRegdate(String tcRegdate) {
		this.tcRegdate = tcRegdate;
	}

	public Timestamp getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Timestamp openDate) {
		this.openDate = openDate;
	}

	public String getTcTitle() {
		return tcTitle;
	}

	public void setTcTitle(String tcTitle) {
		this.tcTitle = tcTitle;
	}

	public String getTcContent() {
		return tcContent;
	}

	public void setTcContent(String tcContent) {
		this.tcContent = tcContent;
	}

	public char getPrivates() {
		return privates;
	}

	public void setPrivates(char privates) {
		this.privates = privates;
	}

	public int getViewCt() {
		return viewCt;
	}

	public void setViewCt(int viewCt) {
		this.viewCt = viewCt;
	}

	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}
	
	
	private List<FileDTO> files;

	public List<FileDTO> getFiles() {
	    return files;
	}

	public void setFiles(List<FileDTO> files) {
	    this.files = files;
	}
	
	private List<TagDTO> tags;

	public List<TagDTO> getTags() {
	    return tags;
	}

	public void setTags(List<TagDTO> tags) {
	    this.tags = tags;
	}
	
	private boolean isOpened;

	public boolean isOpened() {
	    return isOpened;
	}

	public void setOpened(boolean opened) {
	    isOpened = opened;
	}
	
	
}
