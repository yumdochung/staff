package com.mars.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mars.common.Action;
import com.mars.dto.Dto;
import com.mars.staff.dao.StaffDao;

public class StaffLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "staff/login.jsp";

		String sid = request.getParameter("sid");
		String spwd = request.getParameter("spwd");

		StaffDao sa = StaffDao.getInstance();
		int result = sa.loginCheck(sid, spwd);

		if (result == 1) {
			Dto st = sa.getStaff(sid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", st);
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			url = "index.jsp";
		} else if (result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
