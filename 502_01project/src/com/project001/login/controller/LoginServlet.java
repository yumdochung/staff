package com.project001.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project001.common.dto.Dto;
import com.project001.notice.dao.NoticeDao;
import com.project001.staff.dao.StaffDao;
 

@WebServlet("/main.jhj")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if((String)session.getAttribute("sNo")==null)session.setAttribute("ck","1" );
		
		
		NoticeDao dao = NoticeDao.getInstance();
		List<Dto> dto = dao.selectMainNoticeList();
		
		request.setAttribute("notice", dto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main/main.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffDao sd = StaffDao.getInstance();
		String sNo = request.getParameter("id");
		String pWd = request.getParameter("userpwd");
		String admin = sd.getAdmin(sNo);
		//if (pWd.equals(sd.loginCheck(sNo))) {
			HttpSession session = request.getSession();
			session.setAttribute("sNo",sNo );
			session.setAttribute("admin", admin);
			session.setAttribute("ck", "0");
			
			NoticeDao dao = NoticeDao.getInstance();
			List<Dto> dto = dao.selectMainNoticeList();
			
			request.setAttribute("notice", dto);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main/main.jsp");
			dispatcher.forward(request, response);
	//	}
//		else{
//			HttpSession session = request.getSession();
//			NoticeDao dao = NoticeDao.getInstance();
//			List<Dto> dto = dao.selectMainNoticeList();
//			
//			request.setAttribute("notice", dto);
//			session.setAttribute("ck", "2");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("main/main.jsp");
//			dispatcher.forward(request, response);
//		}
	}

}
