package com.mars.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.notice.dao.NoticeDao;

public class NoticeReplyInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String sid = request.getParameter("sid");
		String num = request.getParameter("num");
		String content = request.getParameter("content");
		
		NoticeDao dao = NoticeDao.getInstance();
		
		dao.noticepReplyInsert(sid,num,content);
	}

}
