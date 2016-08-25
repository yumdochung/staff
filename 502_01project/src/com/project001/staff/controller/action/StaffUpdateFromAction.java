package com.project001.staff.controller.action;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project001.common.Action;
import com.project001.common.dto.Dto;
import com.project001.staff.dao.StaffDao;

public class StaffUpdateFromAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "staff/staffRegUpdate.jsp";
		
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		String sNo = request.getParameter("sno");
		StaffDao sda = StaffDao.getInstance();
		Dto sdt = sda.infoStaff(sNo);
		
		StringTokenizer ph = new StringTokenizer(sdt.getsPhone(), "-");
		sdt.setHp1(ph.nextToken());
		sdt.setHp2(ph.nextToken());
		sdt.setHp3(ph.nextToken());
		
		StringTokenizer em = new StringTokenizer(sdt.getEmail(), "@"); 
		sdt.setMail1(em.nextToken());
		sdt.setMail2(em.nextToken());
		request.setAttribute("staffInfo", sdt);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
