package com.project001.notice.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project001.common.Action;
import com.project001.common.dto.Dto;
import com.project001.notice.dao.NoticeDao;

public class NoticeRefly implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");
		String sno = request.getParameter("sno");
		String reply = request.getParameter("reply");
		
		Dto dt = new Dto();
		dt.setNo(Integer.parseInt(no));
		dt.setsNo(sno);
		dt.setReply(reply);
		
		NoticeDao dao = NoticeDao.getInstance();
		dao.noticeRe(dt);
		
		
		PrintWriter out = response.getWriter();
		Dto dto = new Dto();
		dto =dao.replyAjax(no);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		out.print("<tr><td id='rp_id'>"+dto.getWriter()+" : </td><td id='rp'>"+dto.getReply()+"<font id='tm'>("+dto.getRegDt()+")</font></td></tr>");
		out.flush();	
		
	}
	
}
