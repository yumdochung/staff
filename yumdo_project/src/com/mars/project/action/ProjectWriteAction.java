package com.mars.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.project.dao.ProjectDao;
import com.mars.project.dto.ProjectDto;

public class ProjectWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ProjectDto pt = new ProjectDto();
		
		pt.setSid(request.getParameter("sid"));
		pt.setPass(request.getParameter("pass"));
		pt.setStartterm(request.getParameter("startterm"));
		pt.setEndterm(request.getParameter("endterm"));
		pt.setSkill(request.getParameter("skill"));
		pt.setTitle(request.getParameter("title"));
		pt.setContent(request.getParameter("content"));
		
		ProjectDao pa = ProjectDao.getInstance();
		pa.insertProject(pt);
		
		new ProjectListAction().execute(request, response);
	}
}
