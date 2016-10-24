package com.mars.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.notice.dao.NoticeDao;

public class NoticeInsertAction  implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "notice?command=noticeList";
		
		request.setCharacterEncoding("UTF-8");

		String sid = request.getParameter("sid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		NoticeDao dao = NoticeDao.getInstance();
		
		dao.insertNotice(title,content,sid);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
