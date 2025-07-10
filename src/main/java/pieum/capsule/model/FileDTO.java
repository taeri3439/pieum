package pieum.capsule.model;

import java.io.Serializable;

public class FileDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;

	// 타임캡슐
	private String fno;
	private String fileName;
	private byte[] fileData;
	private String tcno;
	
	public FileDTO() {
	}

	public FileDTO(String fno, String fileName, byte[] fileData, String tcno) {
		super();
		this.fno = fno;
		this.fileName = fileName;
		this.fileData = fileData;
		this.tcno = tcno;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	
	
	
	
}
