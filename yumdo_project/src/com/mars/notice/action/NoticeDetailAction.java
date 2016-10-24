package com.mars.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mars.common.Action;
import com.mars.dto.NoticeDTO;
import com.mars.notice.dao.NoticeDao;

public class NoticeDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "notice/NoticeDetail.jsp";
		String num = request.getParameter("num");
		
		NoticeDao dao = NoticeDao.getInstance();
		dao.readcount(num);
		NoticeDTO dto = dao.noticeDetail(num);
		List<NoticeDTO> replydto= dao.noticeReplySelect(num);
		
		request.setAttribute("noticeDto", dto);
		
		request.setAttribute("replyDto", replydto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
