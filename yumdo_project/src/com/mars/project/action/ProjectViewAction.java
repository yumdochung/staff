package com.mars.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.project.dao.ProjectDao;
import com.mars.project.dto.ProjectDto;

public class ProjectViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "project/projectView.jsp";
		
		String num = request.getParameter("num");
		
		ProjectDao pa = ProjectDao.getInstance();
		
		pa.updateReadCount(num);
		
		ProjectDto pt = pa.selectOneProjectByNum(num);
		
		request.setAttribute("project", pt);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
