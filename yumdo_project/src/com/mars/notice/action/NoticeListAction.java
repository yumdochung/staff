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

public class NoticeListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "notice/NoticeList.jsp";
		NoticeDao nda = NoticeDao.getInstance();
		request.setCharacterEncoding("UTF-8");
		
		int curPage = (request.getParameter("curPage")== null)?1:Integer.parseInt(request.getParameter("curPage"));
		int start = (curPage - 1) * 10 + 1;
		int end = start + 10 - 1;
		
		int totalRecord = nda.getTotalRecord();
		int totalPage = 0;
		if(totalRecord != 0){
			if(totalRecord % 10 ==0) {
				totalPage = totalRecord/10;
			}else{
				totalPage = totalRecord/10+1;
			}
		}
		
		int totalBlock = 0;
		int block = 1;
		int pagePerBlock = 5;
		if(curPage%pagePerBlock==0){
			block = curPage/ pagePerBlock;
		}else{
			block = curPage/pagePerBlock +1;
		}
		int firstPage=(block -1)*pagePerBlock +1;
		int lastPage = block * pagePerBlock;
		if(totalPage>0){
			if(totalPage%pagePerBlock==0){
				totalBlock = totalPage / pagePerBlock;
			}else{
				totalBlock = totalPage / pagePerBlock +1;
			}
		}
		if(block >=totalBlock){
			lastPage = totalPage;
		}
		
		int prevPage = firstPage -1;
		int nextPage = lastPage + 1;
		
		request.setAttribute("firstPage", firstPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("block", block);
		request.setAttribute("firstPage", firstPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("prevPage", prevPage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("totalBlock", totalBlock);
		
		List<NoticeDTO> li = nda.pagingNoticeList(start, end);		
		request.setAttribute("noticeList", li);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
