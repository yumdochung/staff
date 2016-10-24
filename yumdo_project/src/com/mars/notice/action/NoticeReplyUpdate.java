package com.mars.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.notice.dao.NoticeDao;

public class NoticeReplyUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		String content = request.getParameter("content");
		
		NoticeDao dao = NoticeDao.getInstance();
		
		dao.noticepReplyUpdate(num,content);
	}

}
