package com.project001.staff.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project001.common.Action;
import com.project001.common.dto.Dto;
import com.project001.staff.dao.StaffDao;

public class StaffUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "staff.jhj?command=staff_list";
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		StaffDao sda = StaffDao.getInstance();
		Dto sdt = new Dto();
		
		int uploadFileSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		String uploadFilePath =(String) request.getAttribute("uploadFilePath");
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		
		if(pictureUrl == null || pictureUrl.equals("") ){
			sdt.setPictureUrl(multi.getParameter("oldPictureUrl")); 
		} else {
			sdt.setPictureUrl(pictureUrl);
		}
		sdt.setsNo(multi.getParameter("sno"));
		sdt.setsName(multi.getParameter("sname"));
		sdt.setJumin1(multi.getParameter("jumin1")); 
		sdt.setJumin2(multi.getParameter("jumin2"));
		sdt.setGenderCd(multi.getParameter("gendercd"));
		sdt.setEmail(multi.getParameter("email1") + "@" + multi.getParameter("email2"));
		sdt.setsPhone(multi.getParameter("hp1") + "-" + multi.getParameter("hp2")+ "-" + multi.getParameter("hp3"));
		sdt.setDeptCd(multi.getParameter("deptcd"));
		sdt.setJobCd(multi.getParameter("jobcd"));
		sdt.setJoinDt(multi.getParameter("joindt"));
		sdt.setRetireDt(multi.getParameter("retiredt"));
		sdt.setZipCode(multi.getParameter("zipcode"));
		sdt.setAddr1( multi.getParameter("addr1"));
		sdt.setAddr2(multi.getParameter("addr2"));
		sdt.setSal(multi.getParameter("sal"));
		sdt.setSkill(multi.getParameter("skill"));
		sdt.setRegDt(multi.getParameter("regdt"));
		sda.updateStaff(sdt);
		response.sendRedirect(url);
	}

}
