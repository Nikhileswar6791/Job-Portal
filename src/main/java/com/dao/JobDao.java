package com.dao;
import com.entity.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.dao.CompanyDao;
import com.entity.Jobs;
import com.DB.DBConnect;

public class JobDao {
	
	private Connection connection;

	public JobDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addJob(Jobs j) {
		
		boolean f=false;
		try {
			String sql = "insert into job values (?,?,?,?,?,?)";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1, j.getId());
			ps.setString(2, j.getTitle());
			ps.setString(3, j.getsalary());
			ps.setString(4, j.getskills());
			ps.setString(5, j.getDescription());
			ps.setString(6,j.getStatus());
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Jobs> getAllJobs() {
		List<Jobs> jobList = new ArrayList<Jobs>();		
		Jobs jobs= null;
		
		try {
			String sql= "select * from job order by job_id desc";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(sql);
			while (rs.next()) {
				jobs= new Jobs();
				jobs.setId(rs.getInt(1));
				jobs.setTitle(rs.getString(2));
				jobs.setsalary(rs.getString(3));
				jobs.setskills(rs.getString(4));
				jobs.setDescription(rs.getString(5));
				jobs.setStatus(rs.getString(6)); 
				jobList.add(jobs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jobList;
	}
	
	public Jobs getJobByID(int id) {				
		Jobs job= null;		
		try {
			String sql= "select * from job where job_id="+id;
			PreparedStatement ps=connection.prepareStatement(sql);
			//ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(sql);
			while (rs.next()) {
				job= new Jobs();
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setskills(rs.getString(4));
				job.setsalary(rs.getString(3));
				job.setStatus(rs.getString(6));
				job.setDescription(rs.getString(5)); 			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return job;
	}
	
	public boolean updateJob(Jobs j) {
		boolean f=false;
		try {
			String sql = "update job set title=?,description=?,skills=?,status=?,salary=? where job_id=?";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getskills());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getsalary());
			ps.setInt(6, j.getId());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteJob(Integer id) {
		boolean f=false;
		try {
			String sql = "delete from job where job_id=?";
			PreparedStatement ps =connection.prepareStatement(sql);			
			ps.setInt(1, id);	
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
