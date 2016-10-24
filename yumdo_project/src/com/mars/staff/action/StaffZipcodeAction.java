package com.mars.staff.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.dto.Dto;
import com.mars.staff.dao.StaffDao;


public class StaffZipcodeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String dong = request.getParameter("dong");
		List<Dto> dto = new ArrayList<Dto>();
		StaffDao dao = StaffDao.getInstance();
		dto = dao.zip(dong);
		
		String obj = "";
		for(Dto a: dto){
		 obj += "<tr><td><input type='button' value='"+a.getZipcode()+"' onclick='zip_chk(\""+a.getZipcode()+"\",\""+a.getSIDO()+a.getGUGUN()+a.getDONG()+a.getRI()+a.getBLDG()+a.getBUNGI()+"\");'></td><td>"
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
