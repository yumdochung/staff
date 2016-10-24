package com.mars.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.notice.dao.NoticeDao;

public class NoticeReplyDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		String notice_num = request.getParameter("notice_num");
		String url = "/notice?command=noticeDetail&num="+notice_num;
		
		NoticeDao dao = NoticeDao.getInstance();
		
		dao.noticepReplyDelete(num);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
