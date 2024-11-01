package model;

public class Course {
	private String ccode;
	private String cname;
	private int duration;
	private int amount;
	private String userid;
	private String active;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String ccode, String cname, int duration, int amount, String userid) {
		this.ccode = ccode;
		this.cname = cname;
		this.duration = duration;
		this.amount = amount;
		this.userid = userid;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
	
}
