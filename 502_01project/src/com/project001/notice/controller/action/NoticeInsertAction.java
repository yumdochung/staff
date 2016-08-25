package com.project001.notice.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project001.common.Action;
import com.project001.notice.dao.NoticeDao;

public class NoticeInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "notice.jhj?command=notice_list";
		
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null) url = "index.jsp";

		NoticeDao sda = NoticeDao.getInstance();
		
		
		String writer = (String)session.getAttribute("sNo");
		String title = request.getParameter("title");
		String content = request.getParameter("content").replace("\r\n","<br>" );
		sda.insertNotice(title, content, writer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
