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
import com.entity.company;

@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String skills = req.getParameter("skills");
			String salary = req.getParameter("salary");
			String status = "Active";
			Random rand = new Random();
	        int j_id = rand.nextInt(100000);
			Jobs jobs = new Jobs();
			jobs.setTitle(title);
			jobs.setDescription(description);
			jobs.setskills(skills);
			jobs.setStatus(status);
			jobs.setId(j_id);
			jobs.setsalary(salary);
			
			HttpSession session = req.getSession();
			
			//saving jobs to db
			JobDao jobDao = new JobDao(DBConnect.getConnction());
			boolean add = jobDao.addJob(jobs);
			
			if(add) {
				Connection connect = DBConnect.getConnction();
				PreparedStatement st = connect.prepareStatement("insert into post values(?,?)");
		 		
		 		company comp = (company) session.getAttribute("compobj");
		 		int x = comp.getId();
		 		st.setInt(1,x);
				st.setInt(2,j_id);
				int i =st.executeUpdate();
				System.out.println("job added");
				session.setAttribute("succMsg", "job posting done successfuly");
				resp.sendRedirect("add_job.jsp");
			} else {
				System.out.println("job not added");
				session.setAttribute("succMsg", "job posting not done. error coming..");
				resp.sendRedirect("add_job.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
