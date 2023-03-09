package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.entity.company;


public class CompanyDao {
	
	private Connection connection;

	public CompanyDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addCompany(company j) {
		
		boolean f=false;
		try {
			String sql = "insert into company values (?,?,?,?,?,?,?)";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1, j.getId());
			ps.setString(2, j.getC_name());
			ps.setString(3, j.getmail());
			ps.setString(4, j.getcity());
			ps.setString(5,j.getDescription());
			
			ps.setString(6, j.getStatus());
			ps.setString(7, j.getpassword());
			
			int i = ps.executeUpdate();
			
			
			if(i==1) {
				f=true;
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<company> getAllCompanies() {
		List<company> companyList = new ArrayList<company>();		
		company company= null;
		
		try {
			String sql= "select * from company order by c_id desc";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(sql);
			while (rs.next()) {
				company = new company();
				company.setId(rs.getInt(1));
				company.setC_name(rs.getString(2));
				company.setmail(rs.getString(3));
				company.setcity(rs.getString(4));
				company.setStatus(rs.getString(6));
				company.setDescription(rs.getString(5));
				companyList.add(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return companyList;
	}
	
	public boolean updateCompany(Integer id,String status) {
		boolean f=false;
		try {
			String sql = "update company set status = ? where c_id=?";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1,status);
			ps.setInt(2, id);	
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public company validateCompany(String username, String password) {
		company comp= null;
		try {
			String sql = "select * from company where c_mail=? and password=? and status = 'yes'";
			PreparedStatement ps =connection.prepareStatement(sql);			
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				comp= new company();
				comp.setId(rs.getInt(1));
				comp.setC_name(rs.getString(2));
				comp.setmail(rs.getString(3));
				comp.setcity(rs.getString(4));
				comp.setDescription(rs.getString(5));
				comp.setStatus(rs.getString(6));
				comp.setpassword(rs.getString(7));
				comp.setRole("company");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comp;
	}
}
