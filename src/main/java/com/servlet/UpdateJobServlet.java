package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDao;
import com.entity.Jobs;

@WebServlet("/update_job")
public class UpdateJobServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("job_id"));
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String salary = req.getParameter("salary");
			String status = req.getParameter("status");
			String skills = req.getParameter("skills");
			Jobs jobs = new Jobs();
			jobs.setId(id);
			jobs.setTitle(title);
			jobs.setDescription(description);
			jobs.setsalary(salary);
			jobs.setStatus(status);
			jobs.setskills(skills);
			
			HttpSession session = req.getSession();
			//updating jobs to db
			JobDao jobDao = new JobDao(DBConnect.getConnction());
			boolean update = jobDao.updateJob(jobs);
			if(update) {
				System.out.println("job updated");
				session.setAttribute("succMsg", "job updated successfuly");
				resp.sendRedirect("view_jobs.jsp");
			} else {
				System.out.println("job not updated");
				session.setAttribute("succMsg", "job not updated. error coming..");
				resp.sendRedirect("view_jobs.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
