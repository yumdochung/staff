package com.project001.staff.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;
import com.project001.common.dto.Dto;
import com.project001.staff.dao.StaffDao;

public class StaffAcaInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String scd = request.getParameter("scd");
		String scname = request.getParameter("scname");
		String subjectnm = request.getParameter("subjectnm");
		String entrancedt = request.getParameter("entrancedt");
		String graduatedt = request.getParameter("graduatedt");
		String graduateyn = request.getParameter("graduateyn");
		String spic = request.getParameter("spic");
		
		Dto sdto = new Dto();
		sdto.setScd(scd);
		sdto.setScname(scname);
		sdto.setSubjectnm(subjectnm);
		sdto.setEntrancedt(entrancedt);
		sdto.setGraduatedt(graduatedt);
		sdto.setGraduateyn(graduateyn);
		sdto.setSpic(spic);
		
		StaffDao sdao = StaffDao.getInstance();
		sdao.in_aca(sdto);
		 
		PrintWriter out = response.getWriter();
		scd = sdto.getScd();
		scname = sdto.getScname();
		subjectnm = sdto.getSubjectnm();
		entrancedt = sdto.getEntrancedt();
		graduatedt = sdto.getGraduatedt();
		graduateyn = sdto.getGraduateyn();
		spic = sdto.getSpic();
		
		try{
		  out=response.getWriter();
		  
		  String obj = "<table class='join_tbl'>"
		  		+ "<colgroup>"
		  		+ "<col width='20%'' />"
		  		+ "<col width='30%' />"
		  		+ "<col width='20%' />"
		  		+ "<col width='30%' />"
		  		+ "</colgroup>"
		  		+ "<tr><th>학력</th><td>"+scd+"</td><th colspan='2'></th></tr>"
		  		+ "<tr><th>학교명</th><td>"+scname+"</td><th>학과명</th><td>"+subjectnm+"</td></tr>"
				+ "<tr><th>입학일</th><td>"+entrancedt+"</td><th>졸업일</th><td>"+graduatedt+"</td></tr>"
				+ "<tr><th>졸업여부</th><td>"+graduateyn+"</td><th>졸업증명 스캔파일</th><td>"+spic+"</td></tr>"
		  		+ "</table>";
		  out.print(obj);
		  out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
			
			
	}

}
