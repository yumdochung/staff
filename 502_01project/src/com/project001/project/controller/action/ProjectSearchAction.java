package com.project001.project.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project001.common.Action;
import com.project001.project.dao.ProjectDAO;
import com.project001.project.dto.ProjectDTO;


public class ProjectSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/project/projectList.jsp";
		
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		String writer = request.getParameter("writer");
		
		String startdt1 = request.getParameter("startdt1");
		
		String startdt2 = request.getParameter("startdt2");
		
		String prjtnm = request.getParameter("prjtnm");
		
		System.out.println(prjtnm + "|" + writer + "|");
		
		
		ProjectDAO pdao = ProjectDAO.getInstance();
		List<ProjectDTO> prjtSearch = pdao.search(writer, startdt1, startdt2, prjtnm);
		
		request.setAttribute("prjt", prjtSearch);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}