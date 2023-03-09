package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import com.DB.DBConnect;
import com.dao.ApplyDao;
import com.dao.CompanyDao;
import com.dao.JobDao;

import com.entity.company;

@WebServlet("/accept_reject")
public class AcceptServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();

			ApplyDao CompanyDao = new ApplyDao(DBConnect.getConnction());
			String email = request.getParameter("mail");
	        if (request.getParameter("button1") != null) 
	        {
	        	boolean change = CompanyDao.updatestatus("Accepted",email);
	        	if(change) {
					System.out.println("Changed Successfully!!");
					session.setAttribute("succMsg", "Status Changed Successfully!!");
					resp.sendRedirect("index.jsp");
				} 
	        	else
	        	{
	        	System.out.println("error");
				session.setAttribute("succMsg", "error coming..");
				resp.sendRedirect("applied_people.jsp");
	        	}
	        } else if (request.getParameter("button2") != null) {
	        	boolean change = CompanyDao.updatestatus("Rejected",email);
	        	if(change) {
					System.out.println("Changed Successfully!!");
					session.setAttribute("succMsg", "Status Changed Successfully!!");
					resp.sendRedirect("index.jsp");
				} 
	        	else
	        	{
	        	System.out.println("error");
				session.setAttribute("succMsg", "error coming..");
				resp.sendRedirect("applied_people.jsp");
	        	}
			
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}