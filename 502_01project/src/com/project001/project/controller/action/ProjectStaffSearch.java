package com.project001.project.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;
import com.project001.project.dao.ProjectDAO;
import com.project001.project.dto.ProjectDTO;

public class ProjectStaffSearch implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String skill = request.getParameter("skill");
		ProjectDAO dao = new ProjectDAO();
		List<ProjectDTO> dto = dao.insertStaffToProject(skill);
		PrintWriter out = response.getWriter();
		for(ProjectDTO i : dto){
			out.print("<tr><input type='hidden' name='sno' value='" + i.getSno()
					+ "'><td><input type='button' value='" + i.getSname()
					+ "' onclick='staff_select(\""+i.getSno()+"\",\""+i.getSname()+"\",\""+i.getDeptname()+"\")'></td><td>" + i.getDeptname()
					+ "</td><td>" + i.getJobname()
					+ "</td><td>" + i.getSkill()
					+ "</td></tr>");
		}
		out.flush();
		out.close();
	}
	
}
