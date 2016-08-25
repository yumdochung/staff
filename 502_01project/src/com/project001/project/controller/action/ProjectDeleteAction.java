package com.project001.project.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;
import com.project001.project.dao.ProjectDAO;


public class ProjectDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int prjtno = Integer.parseInt(request.getParameter("prjtno"));
		System.out.println(prjtno);
		
		ProjectDAO pdao = ProjectDAO.getInstance();
		pdao.prjt_del(prjtno);
		
		new ProjectListAction().execute(request, response);
	}

}