package com.project001.project.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;
import com.project001.project.dao.ProjectDAO;
import com.project001.project.dto.ProjectDTO;



public class ProjectUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectDTO pdto = new ProjectDTO();
		
		pdto.setPrjtno(Integer.parseInt(request.getParameter("prjtno")));
		pdto.setPrjtnm(request.getParameter("prjtnm"));
		pdto.setStartdt(request.getParameter("startdt"));
		pdto.setEnddt(request.getParameter("enddt"));
		pdto.setPrjtskill(request.getParameter("prjtskill"));
		pdto.setPrjtcontent(request.getParameter("prjtcontent"));

		ProjectDAO pdao = ProjectDAO.getInstance();
		pdao.update(pdto);
		
		new ProjectListAction().execute(request, response);
	}

}
