package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.staff.dao.StaffDao;

public class StaffOkmanAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String url = "staff/okman.jsp";
		
		String sid = request.getParameter("sid");
		String spwd = request.getParameter("spwd");
		
		StaffDao sa=StaffDao.getInstance();
		int result=sa.loginCheck(sid, spwd);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
