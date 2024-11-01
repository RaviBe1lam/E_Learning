package model;

public class Order {
	private int orderno;
	private String ccode;
	private String userid;
	private String pur_date;
	public Order(int orderno, String ccode, String userid, String pur_date) {
		this.orderno = orderno;
		this.ccode = ccode;
		this.userid = userid;
		this.pur_date = pur_date;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPur_date() {
		return pur_date;
	}
	public void setPur_date(String pur_date) {
		this.pur_date = pur_date;
	}
	
	
}
