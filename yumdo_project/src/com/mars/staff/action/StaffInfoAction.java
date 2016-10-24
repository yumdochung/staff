package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.dto.Dto;
import com.mars.staff.dao.StaffDao;

public class StaffInfoAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "staff/staffinfo.jsp";
		request.setCharacterEncoding("UTF-8");
		
		String joindt = request.getParameter("joindt");
		String snm = request.getParameter("snm");
		String sid = request.getParameter("sid");
		String jobcd = request.getParameter("jobcd");
		String sphone = request.getParameter("sphone");
		String email = request.getParameter("email");
		
		
		Dto st = new Dto();
		st.setJoindt(joindt);
		st.setSnm(snm);
		st.setSid(sid);
		st.setJobcd(jobcd);
		st.setSphone(sphone);
		st.setEmail(email);
		
		StaffDao sa = StaffDao.getInstance();
		
		response.sendRedirect("staff?command=staff_info_form");
	}
}