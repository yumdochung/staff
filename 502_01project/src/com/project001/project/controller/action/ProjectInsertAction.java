package com.project001.project.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.dto.Dto;
import com.project001.staff.dao.StaffDao;


public class ProjectInsertAction implements ProjectAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String licnm = request.getParameter("licnm");
		String issue = request.getParameter("issue");
		String issuedt = request.getParameter("issuedt");
		String licpic = request.getParameter("licpic");
		
		System.out.println(licnm);
		
		Dto sdto = new Dto();
		sdto.setLicnm(licnm);
		sdto.setIssue(issue);
		sdto.setIssuedt(issuedt);
		sdto.setLicpic(licpic);
		
		StaffDao sdao = StaffDao.getInstance();
		sdao.in_lic(sdto);
		 
		PrintWriter out = response.getWriter();
		licnm = sdto.getLicnm();
		issue = sdto.getIssue();
		issuedt = sdto.getIssuedt();
		licpic = sdto.getLicpic();
		try{
		  out=response.getWriter();
		  
		  String obj = "<table class='join_tbl'>"
		  		+ "<colgroup>"
		  		+ "<col width='20%'' />"
		  		+ "<col width='30%' />"
		  		+ "<col width='20%' />"
		  		+ "<col width='30%' />"
		  		+ "</colgroup>"
		  		+ "<tr><th>자격증명</th><td>"+licnm+"</td><th>발급처</th><td>"+issue+"</td></tr>"
		  		+ "<tr><th>발급일</th><td>"+issuedt+"</td><th>자격증 스캔파일</th><td>"+licpic+"</td></tr>"
		  		+ "</table>";
		  out.print(obj);
		  out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}