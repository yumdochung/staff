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


public class StaffInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "staff/staffInfo.jsp";
		
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		String sNo = request.getParameter("sno");
		StaffDao sda = StaffDao.getInstance();
		Dto staffInfo = sda.infoStaff(sNo);
		
		request.setAttribute("staffInfo", staffInfo);
		
		List<Dto> staff_lic = sda.out_lic(sNo);
		request.setAttribute("stafflic", staff_lic);
		
		List<Dto> staff_car = sda.out_career(sNo);
		request.setAttribute("staffcar", staff_car);
		
		List<Dto> staff_aca = sda.out_aca(sNo);
		request.setAttribute("staffaca", staff_aca);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
