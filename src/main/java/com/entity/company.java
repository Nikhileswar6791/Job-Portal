package com.entity;

public class company {
	private int c_id;
	private String c_name;
	private String c_mail;
	private String city;
	private String about;
	private String status;
	private String password;
	private String role;
	public company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public company(int c_id,String c_name, String c_mail, String city, String about,String status,String password,String role) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_mail = c_mail;
		this.city = city;
		this.about = about;
		this.status = status;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return c_id;
	}

	public void setId(int id) {
		this.c_id = id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getmail() {
		return c_mail;
	}

	public void setmail(String c_mail) {
		this.c_mail = c_mail;
	}

	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setDescription(String about) {
		this.about = about;
	}
	public String getDescription() {
		return about;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void setpassword(String pass) {
		this.password = pass;
	}
	public String getpassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
