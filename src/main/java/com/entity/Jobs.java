package com.entity;

public class Jobs {
	private int id;
	private String title;
	private String description;
	private String skills;
	private String status;
	private String salary;
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jobs(String title, String description, String skills, String status, String salary) {
		super();
		this.title = title;
		this.description = description;
		this.skills=skills;
		this.status = status;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getsalary() {
		return salary;
	}

	public void setsalary(String salary) {
		this.salary = salary;
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
