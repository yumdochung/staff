package com.mars.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.dto.NoticeDTO;
import com.mars.notice.dao.NoticeDao;

public class NoticeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "notice/NoticeUpdate.jsp";
		
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		NoticeDao dao = NoticeDao.getInstance();
		NoticeDTO dto = dao.noticeDetail(num);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
