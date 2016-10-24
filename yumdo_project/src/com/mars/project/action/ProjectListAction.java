package com.mars.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.project.dao.ProjectDao;
import com.mars.project.dto.ProjectDto;


public class ProjectListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String url = "project/projectList.jsp";
		
		ProjectDao pa=ProjectDao.getInstance();
		
		List<ProjectDto> projectList = pa.selectAllProjects();
		
		request.setAttribute("projectList", projectList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
