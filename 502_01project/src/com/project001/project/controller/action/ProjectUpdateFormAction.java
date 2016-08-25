package com.project001.project.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project001.common.Action;
import com.project001.project.dao.ProjectDAO;
import com.project001.project.dto.ProjectDTO;


public class ProjectUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/project/projectUpdate.jsp";
		
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		int prjtno = Integer.parseInt(request.getParameter("prjtno"));
		
		ProjectDAO pdao = ProjectDAO.getInstance();
		ProjectDTO projectList = pdao.info(prjtno);
		
		request.setAttribute("prjt", projectList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}