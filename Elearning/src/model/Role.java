package model;

public class Role {

	private String rolename;
	private String code;
	
	public Role(String rolename, String code) {
		this.rolename = rolename;
		this.code = code;
	}	

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
