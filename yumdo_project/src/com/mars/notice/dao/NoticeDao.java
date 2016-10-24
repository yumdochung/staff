package com.mars.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mars.common.DBManager;
import com.mars.dto.NoticeDTO;

public class NoticeDao {
	private NoticeDao(){
	}
	
	private static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance() {
		return instance;
	}
	
	public int insertNotice(String title, String content, String sid){
		String sql= "insert into notice (num, title, content, sid) 					"
				+ "    	   values ((SELECT NVL(MAX(num) +1, 1) FROM notice), ?, ?, ?)";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, sid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(null, pstmt, conn);
		}
		return result;
	}
	
	public int getTotalRecord() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalRecord = 0;
		String sql = "select count(*) from notice";
		
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalRecord = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return totalRecord;
	}

	public List<NoticeDTO> pagingNoticeList(int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDTO dto = null;
		List<NoticeDTO> li = new ArrayList<>();
		
		String sql = "select num, title, to_char(regdt, 'yyyy-mm-dd') as regdt, readcount 			"
				+ "	, (SELECT COUNT(num) FROM notice_reply WHERE notice_num = b.num AND delyn = 'N') AS replycount 	"
				+ "		from (select rownum r, a.* from 											"
				+ "			 (select * from notice where delyn = 'N' order by num desc)a)b  			"
				+ "		where r between ? and ?										";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto = new NoticeDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setRegdt(rs.getString("regdt"));
				dto.setReadcount(rs.getString("readcount"));
				dto.setReplycount(rs.getString("replycount"));
				
				li.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return li;
	}

	public NoticeDTO noticeDetail(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDTO dto = null;
		String sql = "select n.num,s.snm,n.sid,n.title,n.content,n.regdt,readcount "
				+ "from notice n,staff s where n.num = ? and n.delyn = 'N' and s.sid = n.sid ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto = new NoticeDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setRegdt(rs.getString("regdt"));
				dto.setSid(rs.getString("sid"));
				dto.setSnm(rs.getString("snm"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getString("readcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		
		return dto;
	}

	public List<NoticeDTO> noticeReplySelect(String num) {
		List<NoticeDTO> li = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDTO dto = null;
		String sql = "select r.num,r.sid,s.snm,r.content, to_char(r.regdt,'yyyy-mm-dd') regdt "
				+ "from staff s,notice_reply r "
				+ "where r.notice_num = ? and s.sid = r.sid and r.delyn = 'N' order by num";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto = new NoticeDTO();
				dto.setNum(rs.getString("num"));
				dto.setSnm(rs.getString("snm"));
				dto.setSid(rs.getString("sid"));
				dto.setContent(rs.getString("content"));
				dto.setRegdt(rs.getString("regdt"));
				li.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		
		return li;
	}

	public void noticeUpdate(String num, String title, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update notice set title = ?,content=? where num = ? ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(null, pstmt, conn);
		}
	}
	
	public void noticeDelete(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from notice where num = ? ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(null, pstmt, conn);
		}
	}

	public void noticepReplyInsert(String sid, String num, String content) {
		String sql= "insert into notice_reply (num, notice_num,sid,content) 					"
				+ "    	   values ((SELECT NVL(MAX(num) +1, 1) FROM notice_reply), ?, ?, ?)";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, sid);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(null, pstmt, conn);
		}
	}
	public void noticepReplyUpdate(String num, String content) {
		String sql= "update notice_reply set content = ? where num = ?";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(null, pstmt, conn);
		}
	}
	public void noticepReplyDelete(String num) {
		String sql= "update notice_reply set delyn = 'Y' where num = ?";
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(null, pstmt, conn);
		}
	}

	public void readcount(String num) {
		String sql= "update notice set readcount = readcount+1 where num = ?";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(null, pstmt, conn);
		}
	}

	public List<NoticeDTO> mainNotice() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDTO dto = null;
		List<NoticeDTO> li = new ArrayList<>();
		
		String sql = "select num, title, to_char(regdt, 'yyyy-mm-dd') as regdt, readcount 			"
				+ "	, (SELECT COUNT(num) FROM notice_reply WHERE notice_num = b.num AND delyn = 'N') AS replycount 	"
				+ "		from (select rownum r, a.* from 											"
				+ "			 (select * from notice where delyn = 'N' order by num desc)a)b  			"
				+ "	   where r between 1 and 5									";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto = new NoticeDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setRegdt(rs.getString("regdt"));
				dto.setReplycount(rs.getString("replycount"));
				
				li.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return li;
	}
}
