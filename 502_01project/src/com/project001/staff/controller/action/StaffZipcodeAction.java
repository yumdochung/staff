package com.project001.staff.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;
import com.project001.common.dto.Dto;
import com.project001.staff.dao.StaffDao;

public class StaffZipcodeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dong = request.getParameter("dong");
		List<Dto> dto = new ArrayList<Dto>();
		StaffDao dao = StaffDao.getInstance();
		dto = dao.zip(dong);
		
		String obj = "";
		for(Dto a: dto){
		 obj += "<tr><td><input type='button' value='"+a.getZipCode()+"' onclick='zip_chk(\""+a.getZipCode()+"\",\""+a.getSIDO()+a.getGUGUN()+a.getDONG()+a.getRI()+a.getBLDG()+a.getBUNGI()+"\");'></td><td>"
				 +a.getSIDO()+" "
				 +a.getGUGUN()+" "
				 +a.getDONG()+" "
				 +a.getRI()+" "
				 +a.getBLDG()+" "
				 +a.getBUNGI()
				 +"</td></tr>";
		}
		PrintWriter out = response.getWriter();
		out.print(obj);
		
		
	}

}
