package com.entity;

public class apply {
	private String u_email;
	private int job_id;
	private String e_title;
	private String e_college;
	private String e_pass;
	private String x_pass;
	private String x_college;
	private String description;
	private String skills;
	private String status;
	public apply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public apply(int job_id,String u_email,String e_title,String e_college,String e_pass,String x_pass,String x_college,String description, String skills, String status) {
		super();
		this.u_email = u_email;
		this.e_college = e_college;
		this.e_pass = e_pass;
		this.e_title = e_title;
		this.x_pass = x_pass;
		this.x_college = x_college;
		this.job_id = job_id;
		this.description = description;
		this.skills=skills;
		this.status = status;
	}

	public String getemail() {
		return u_email;
	}

	public void setemail(String email) {
		this.u_email = email;
	}
    public int getId() {
    	return job_id;
    }
    public void setID(int id) {
		this.job_id = id;
	}
	public String get_eTitle() {
		return e_title;
	}

	public void set_eTitle(String title) {
		this.e_title = title;
	}
	public String get_eCollege() {
		return e_college;
	}

	public void set_eCollege(String title) {
		this.e_college = title;
	}
	public String get_ePass() {
		return e_pass;
	}

	public void set_ePass(String title) {
		this.e_pass = title;
	}
	
	public String get_xPass() {
		return x_pass;
	}

	public void set_xPass(String title) {
		this.x_pass = title;
	}
	public String get_xCollege() {
		return x_college;
	}

	public void set_xCollege(String title) {
		this.x_college = title;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getskills() {
		return skills;
	}

	public void setskills(String skills) {
		this.skills = skills;
	}
	
}
