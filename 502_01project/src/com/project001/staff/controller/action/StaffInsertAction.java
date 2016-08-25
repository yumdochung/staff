package com.project001.staff.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project001.common.Action;
import com.project001.staff.dao.StaffDao;

public class StaffInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "staff.jhj?command=staff_insert2_form";
		
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		int uploadFileSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		String uploadFilePath =(String) request.getAttribute("uploadFilePath");
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		String sName = multi.getParameter("sname");
		String jumin1 = multi.getParameter("jumin1");
		String jumin2 = multi.getParameter("jumin2");
		String gendercd = multi.getParameter("gendercd");
		String email = multi.getParameter("email1") + "@" + multi.getParameter("email2");
		String sPhone = multi.getParameter("hp1") + "-" + multi.getParameter("hp2")+ "-" + multi.getParameter("hp3");
		String deptCd = multi.getParameter("deptcd");
		String jobCd = multi.getParameter("jobcd");
		String zipCode = multi.getParameter("zipcode");
		String addr1 = multi.getParameter("addr1");
		String addr2 = multi.getParameter("addr2");
		String sal = multi.getParameter("sal");
		String skill = multi.getParameter("skill").replace("\r\n","<br>" );
		

		StaffDao sda = StaffDao.getInstance();
		sda.insertStaff(pictureUrl, sName, jumin1, jumin2, gendercd, email, sPhone, deptCd, jobCd, zipCode, addr1, addr2, sal, skill);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
