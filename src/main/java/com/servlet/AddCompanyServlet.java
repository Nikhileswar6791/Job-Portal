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
import com.dao.CompanyDao;
import com.dao.JobDao;

import com.entity.company;

@WebServlet("/add_company")
public class AddCompanyServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String c_name = req.getParameter("c_name");
			String c_mail = req.getParameter("c_mail");
			String city = req.getParameter("c_city");
			String status = "no";
			String about = req.getParameter("about");
			String pass = req.getParameter("password");
			Random rand = new Random();
	        int c_id = rand.nextInt(100000);
	        
			company company = new company();
			company.setId(c_id);
			company.setC_name(c_name);
			company.setmail(c_mail);
			company.setStatus(status);
			company.setDescription(about);
			company.setpassword(pass);
			company.setcity(city);
			HttpSession session = req.getSession();
			
			//saving jobs to db
			CompanyDao CompanyDao = new CompanyDao(DBConnect.getConnction());
			boolean add = CompanyDao.addCompany(company);
			if(add) {
				System.out.println("Request Sent!!");
				session.setAttribute("succMsg", "Request Sent Successfully!!");
				resp.sendRedirect("index.jsp");
			} else {
				System.out.println("error");
				session.setAttribute("succMsg", "Request not sent. error coming..");
				resp.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}