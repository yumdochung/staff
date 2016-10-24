package com.mars.staff.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.dto.Dto;
import com.mars.staff.dao.StaffDao;

public class StaffListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String url = "staff/stafflist.jsp";
		
		
		StaffDao sa= StaffDao.getInstance();
		
		List<Dto> stafflist= sa.selectAllStaff();
		
		request.setAttribute("staffList",stafflist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
