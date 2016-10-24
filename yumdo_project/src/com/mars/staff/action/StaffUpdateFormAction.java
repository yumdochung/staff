package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.dto.Dto;
import com.mars.staff.dao.StaffDao;

public class StaffUpdateFormAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sid = request.getParameter("sid");
		StaffDao sa = StaffDao.getInstance();
		
		Dto st = sa.getStaff(sid);
		request.setAttribute("st", st);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("staff/staffupdate.jsp");
		dispatcher.forward(request, response);
		}
	}

