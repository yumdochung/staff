package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;

public class StaffLoginFormAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("staff/login.jsp");
		request.setAttribute("sid", request.getParameter("sid"));
		dispatcher.forward(request, response);
		

	}
}