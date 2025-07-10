package pieum.user.model;

import java.sql.Timestamp;

public class GroupDTO {

	private String gno;
	private String gName;
	private int gMemberCt;
	private Timestamp gRegdate;
	
	public GroupDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public GroupDTO(String gno, String gName, int gMemberCt, Timestamp gRegdate) {
		super();
		this.gno = gno;
		this.gName = gName;
		this.gMemberCt = gMemberCt;
		this.gRegdate = gRegdate;
	}

	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgMemberCt() {
		return gMemberCt;
	}

	public void setgMemberCt(int gMemberCt) {
		this.gMemberCt = gMemberCt;
	}

	public Timestamp getgRegdate() {
		return gRegdate;
	}

	public void setgRegdate(Timestamp gRegdate) {
		this.gRegdate = gRegdate;
	}
	
	
	
	
	
}
