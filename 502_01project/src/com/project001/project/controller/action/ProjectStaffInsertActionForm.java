package com.project001.project.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;
import com.project001.project.dao.ProjectDAO;
import com.project001.project.dto.ProjectDTO;

public class ProjectStaffInsertActionForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String writer = request.getParameter("writer");
		String sno = request.getParameter("sno");
		String prjtno = request.getParameter("prjtno");
		String rolecd = request.getParameter("rolecd");
		
		ProjectDTO dto = new ProjectDTO();
		ProjectDAO pda = ProjectDAO.getInstance();
		
		dto.setSpwriter(writer);
		dto.setSno(sno);
		dto.setPrjtno(Integer.parseInt(prjtno));
		dto.setRolecd(rolecd);
		
		pda.insertProjectStaff(dto);
		
		ProjectDTO sdto = pda.selectForInsertProjectStaff(sno);
		String rcd = null;
		
		switch (sdto.getRolecd()) {
		case "00  ":
			rcd="DEV";
			break;
		case "01  ":
			rcd="PL";
			break;
		case "10  ":
			rcd="PM";
			break;
		case "11  ":
			rcd="PMO";
			break;
		case "21  ":
			rcd="SALES";
			break;
		
		}
		
		PrintWriter out = response.getWriter();
		
		out.print("<tr><td>"+sdto.getSno()
				+ "</td><td>"+sdto.getSname()
				+ "</td><td>"+sdto.getDeptname()
				+ "</td><td>"+rcd
				+ "</td></tr>");
		
		out.flush();
		out.close();

	}

}
