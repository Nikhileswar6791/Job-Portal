package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.apply;
import com.entity.company;


public class ApplyDao {
	
	private Connection connection;

	public ApplyDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean updatestatus(String s,String m)
	{
		boolean f= false;
		try {
			String sql= "update apply set status = ? where u_email=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,s);
			ps.setString(2, m);
            int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
	}
	public List<apply> getjobs_applied(String x) {
		List<apply> companyList = new ArrayList<apply>();		
		apply company= null;
		
		try {
			String sql1= "select job.title,job.salary,job.description,apply.status from apply,job where apply.job_id = job.job_id order by apply.job_id desc";
			PreparedStatement ps=connection.prepareStatement(sql1);
			ResultSet rs=ps.executeQuery(sql1);
			while (rs.next()) {
				company = new apply();
				company.set_eTitle(rs.getString(1));
				company.setskills(rs.getString(2));
				company.setStatus(rs.getString(4));
				company.setDescription(rs.getString(3));
				companyList.add(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return companyList;
	}
	
	public List<apply> getpeople_applied(int x) {
		List<apply> companyList = new ArrayList<apply>();		
		apply company= null;
		
		try {
			String sql= "select * from apply order by job_id desc;";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(sql);
			while (rs.next()) {
				company = new apply();
				company.setemail(rs.getString(1));
				company.setID(rs.getInt(2));
				company.set_eTitle(rs.getString(3));
				company.set_eCollege(rs.getString(4));
				company.set_ePass(rs.getString(5));
				company.set_xPass(rs.getString(7));
				company.set_xCollege(rs.getString(6));
				company.setDescription(rs.getString(8));
				company.setskills(rs.getString(9));
				company.setStatus(rs.getString(10));
				companyList.add(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return companyList;
	}}