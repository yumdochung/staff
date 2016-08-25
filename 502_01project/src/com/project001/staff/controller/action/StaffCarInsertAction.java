package com.project001.staff.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;
import com.project001.common.dto.Dto;
import com.project001.staff.dao.StaffDao;


public class StaffCarInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			String prjtnm = request.getParameter("prjtnm");
			String prjtskill = request.getParameter("prjtskill");
			String startdt = request.getParameter("startdt");
			String enddt = request.getParameter("enddt");
			String ordernm = request.getParameter("ordernm");
			String rolecd = request.getParameter("rolecd");
			
			Dto sdto = new Dto();
			sdto.setPrjtnm(prjtnm);
			sdto.setPrjtskill(prjtskill);
			sdto.setStartdt(startdt);
			sdto.setEnddt(enddt);
			sdto.setOrdernm(ordernm);
			sdto.setRolecd(rolecd);
			
			StaffDao sdao = StaffDao.getInstance();
			sdao.in_career(sdto);		 
			PrintWriter out = response.getWriter();
			
			prjtnm = sdto.getPrjtnm();
			prjtskill = sdto.getPrjtskill();
			startdt = sdto.getStartdt();
			enddt = sdto.getEnddt();
			ordernm = sdto.getOrdernm();
			rolecd = sdto.getRolecd();
			try{
			  out=response.getWriter();
			  
			  String obj = "<table class='join_tbl'>"
			  		+ "<colgroup>"
			  		+ "<col width='20%'' />"
			  		+ "<col width='30%' />"
			  		+ "<col width='20%' />"
			  		+ "<col width='30%' />"
			  		+ "</colgroup>"
			  		+ "<tr><th>������Ʈ��</th><td>"+prjtnm+"</td><th>�ҿ���</th><td>"+prjtskill+"</td></tr>"
			  		+ "<tr><th>������</th><td>"+startdt+"</td><th>������</th><td>"+enddt+"</td></tr>"
					+ "<tr><th>����ó</th><td>"+ordernm+"</td><th>����</th><td>"+rolecd+"</td></tr>"
			  		+ "</table>";
			  out.print(obj);
			  out.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
	}

}
