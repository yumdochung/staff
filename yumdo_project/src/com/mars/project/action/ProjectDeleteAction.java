package com.mars.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.project.dao.ProjectDao;

public class ProjectDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num=request.getParameter("num");
		
		ProjectDao pa=ProjectDao.getInstance();
		pa.deleteProject(num);
		
		new ProjectListAction().execute(request, response);
	}
}
