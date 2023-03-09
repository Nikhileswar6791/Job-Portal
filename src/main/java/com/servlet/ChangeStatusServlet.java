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

@WebServlet("/company_status")
public class ChangeStatusServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String status = req.getParameter("status");
	        int c_id = Integer.parseInt(req.getParameter("c_id"));
	        
			HttpSession session = req.getSession();

			CompanyDao CompanyDao = new CompanyDao(DBConnect.getConnction());
			boolean change = CompanyDao.updateCompany(c_id,status);
			if(change) {
				System.out.println("Changed Successfully!!");
				session.setAttribute("succMsg", "Status Changed Successfully!!");
				resp.sendRedirect("admin.jsp");
			} else {
				System.out.println("error");
				session.setAttribute("succMsg", "error coming..");
				resp.sendRedirect("change.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}