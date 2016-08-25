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
		  		+ "<tr><th>�з�</th><td>"+scd+"</td><th colspan='2'></th></tr>"
		  		+ "<tr><th>�б���</th><td>"+scname+"</td><th>�а���</th><td>"+subjectnm+"</td></tr>"
				+ "<tr><th>������</th><td>"+entrancedt+"</td><th>������</th><td>"+graduatedt+"</td></tr>"
				+ "<tr><th>��������</th><td>"+graduateyn+"</td><th>�������� ��ĵ����</th><td>"+spic+"</td></tr>"
		  		+ "</table>";
		  out.print(obj);
		  out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
			
			
	}

}
