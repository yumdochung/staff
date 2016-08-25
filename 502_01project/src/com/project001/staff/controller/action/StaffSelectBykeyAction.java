package com.project001.staff.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project001.common.Action;
import com.project001.common.dto.Dto;
import com.project001.staff.dao.StaffDao;

public class StaffSelectBykeyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "staff/staffList.jsp";
		
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		String sNo = request.getParameter("sno");
		String joinDt1 = request.getParameter("joindt1");
		String joinDt2 = request.getParameter("joindt2");
		String sName = request.getParameter("sname");
		
		

		StaffDao sda = StaffDao.getInstance();
		List<Dto> li = sda.selectStaffByKeyword(sNo, joinDt1, joinDt2, sName);
		
		
		request.setAttribute("staffList", li);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
