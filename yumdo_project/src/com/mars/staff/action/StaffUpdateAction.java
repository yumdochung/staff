package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.dto.Dto;
import com.mars.staff.dao.StaffDao;

public class StaffUpdateAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String url = "staff/staffupdate.jsp";
			request.setCharacterEncoding("UTF-8");
			
			String sid = request.getParameter("sid");
			String spwd = request.getParameter("spwd");
			String email = request.getParameter("email");
			String sphone = request.getParameter("sphone");
			String jumin = request.getParameter("jumin");
			String zipcode = request.getParameter("zipcode");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			
			
			Dto st = new Dto();
			st.setSid(sid);
			st.setSpwd(spwd);
			st.setEmail(email);
			st.setSphone(sphone);
			st.setJumin(jumin);
			st.setZipcode(zipcode);
			st.setAddr1(addr1);
			st.setAddr2(addr2);
			
			
			StaffDao sa = StaffDao.getInstance();
			
			sa.updateMember(st);
			response.sendRedirect("staff?command=staff_login_form");
	}
}
