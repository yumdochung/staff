package com.mars.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.project.dao.ProjectDao;
import com.mars.project.dto.ProjectDto;

public class ProjectCheckPassAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		ProjectDao pa = ProjectDao.getInstance();
		ProjectDto pt = pa.selectOneProjectByNum(num);
		
		if(pt.getPass().equals(pass)){
			url = "project/checkSuccess.jsp";
		} else {
			url = "project/projectCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
