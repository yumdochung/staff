package com.project001.notice.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project001.common.Action;
import com.project001.common.dto.Dto;
import com.project001.notice.dao.NoticeDao;

public class NoticeInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "notice/noticeInfo.jsp";
		NoticeDao nda = NoticeDao.getInstance();
		NoticeDao rda = NoticeDao.getInstance();
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";
		
		int no = Integer.parseInt(request.getParameter("no"));
		nda.cnt(no);
		Dto noticeInfo = nda.selectNoticeInfo(no);
		List<Dto> li = new ArrayList<Dto>();
		li = rda.noticeResel(no);
		request.setAttribute("noticerp", li);
		request.setAttribute("noticeInfo", noticeInfo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
