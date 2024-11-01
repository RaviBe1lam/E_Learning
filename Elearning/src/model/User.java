package model;

public class User {
	private String name;
	private int age;	
	private String phone;
	private String gender;
	private String pwd;
	private Address address;
	private String role;
	private String email;
	private String active;
	private String addressid;
	
	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}



	public User(String name, int age, String phone, String gender, String pwd, Address address, String role,
			String email) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.gender = gender;
		this.pwd = pwd;
		this.address = address;
		this.role = role;
		this.email = email;
	}
	
	
	
	public String getActive() {
		return active;
	}



	public void setActive(String active) {
		this.active = active;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
}
