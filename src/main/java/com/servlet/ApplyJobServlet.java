package com.servlet;

import java.io.IOException;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDao;
import com.entity.Jobs;
import com.entity.User;
import com.entity.company;

@WebServlet("/apply_job")
public class ApplyJobServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String e_title = req.getParameter("e_title");
			String e_college = req.getParameter("e_college");
			String e_pass = req.getParameter("e_pass");
			String x_college = req.getParameter("x_college");
			String x_pass = req.getParameter("x_pass");
			String experience = req.getParameter("description");
			String skills = req.getParameter("skills");
	        int j_id = Integer.parseInt(req.getParameter("job_id"));
	        String status = "On hold";
			
			HttpSession session = req.getSession();
			
			//saving jobs to db
			Connection connect = DBConnect.getConnction();
			PreparedStatement st = connect.prepareStatement("insert into apply values(?,?,?,?,?,?,?,?,?,?)");
			User comp = (User) session.getAttribute("userobj");
	 		String x = comp.getEmail();
			st.setString(1,x);
			st.setInt(2,j_id);
			st.setString(3, e_title);
			st.setString(4, e_college);
			st.setString(5, e_pass);
			st.setString(6, x_college);
			st.setString(7, x_pass);
			st.setString(8, experience);
			st.setString(9, skills);
			st.setString(10, status);
			int i =st.executeUpdate();
			if(i==1) {
				System.out.println("job applied Successfully");
				session.setAttribute("succMsg", "job applied successfuly");
				resp.sendRedirect("apply.jsp");
			} else {
				System.out.println("job not applied");
				session.setAttribute("succMsg", "job not applied. error coming..");
				resp.sendRedirect("apply.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
