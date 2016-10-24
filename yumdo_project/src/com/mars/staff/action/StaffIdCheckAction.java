package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.staff.dao.StaffDao;

public class StaffIdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "staff/idcheck.jsp";
		
		String sid = request.getParameter("sid");
		
		StaffDao sa = StaffDao.getInstance();
		
		int result = sa.confirmID(sid);
		
		request.setAttribute("sid", sid);
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("staff/idcheck.jsp");
		dispatcher.forward(request, response);
	}
	
}
