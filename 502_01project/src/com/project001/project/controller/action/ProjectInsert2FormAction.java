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


public class ProjectInsert2FormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/project/projectInsert2.jsp";
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		ProjectDTO pdto = new ProjectDTO();
		
		String writer = request.getParameter("writer");
		String prjtnm = request.getParameter("prjtnm");
		String startdt = request.getParameter("startdt");
		String enddt = request.getParameter("enddt");
		String ordernm = request.getParameter("ordernm");
		String prjtskill = request.getParameter("prjtskill").replace("\r\n","<br>" );
		String prjtcontent = request.getParameter("prjtcontent").replace("\r\n","<br>" );
		
		pdto.setWriter(writer);
		pdto.setPrjtnm(prjtnm);
		pdto.setStartdt(startdt);
		pdto.setEnddt(enddt);
		pdto.setOrdernm(ordernm);
		pdto.setPrjtskill(prjtskill);
		pdto.setPrjtcontent(prjtcontent);
		
		ProjectDAO pdao = ProjectDAO.getInstance();
		pdao.insert(pdto);
		ProjectDTO prjtinsert2 = pdao.prjtnosearch();
		request.setAttribute("prjt", prjtinsert2);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}			

}