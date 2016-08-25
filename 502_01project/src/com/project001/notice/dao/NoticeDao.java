package com.project001.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project001.common.Dbcp;
import com.project001.common.TimeCheck;
import com.project001.common.dto.Dto;

public class NoticeDao {
	private NoticeDao(){
	}
	private static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance (){
		return instance;
	}
	
	public List<Dto> selectMainNoticeList (){
		Dbcp dc = new Dbcp();
		List<Dto> li = new ArrayList<Dto>();
		
		String sql = "select no, title, to_char(regdt, 'yyyy-mm-dd') as regdt "
				+ " from (select rownum r, a.* from (select * from notice WHERE delyn = 'N' ORDER by regdt desc)a) where r between 1 and 5";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Dto dt = new Dto();
				dt.setNo(rs.getInt("no"));
				dt.setTitle(rs.getString("title"));
				dt.setnRegDt(rs.getString("regdt"));
				li.add(dt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return li;
			
	
	}
	
	public List<Dto> selectAllNoticeList (){
		Dbcp dc = new Dbcp();
		List<Dto> li = new ArrayList<Dto>();
		
		String sql = "select no, title, to_char(regdt, 'yyyy/mm/dd') as regdt, cnt from notice where delyn = 'N' order by no desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Dto dt = new Dto();
				dt.setNo(rs.getInt("no"));
				dt.setTitle(rs.getString("title"));
				dt.setnRegDt(rs.getString("regdt"));
				dt.setCnt(rs.getInt("cnt"));				
				li.add(dt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return li;
			
	
	}
	
//	public Dto selectListByNo(int no){
//		Dbcp dc = new Dbcp();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		Dto dto = null;
//		
//		String sql = "select to_char(regdt, 'yyyy/mm/dd'), cnt from notice where no = ?";
//	}
	
	
	public void insertNotice (String title, String content, String writer) {
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		String sql = "insert into notice (no, title, content, writer) 					"
				+ "    	   values ((SELECT NVL(MAX(no) +1, 1) FROM notice), ?, ?, ?)	";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);
		}
	}
	
	public Dto selectNoticeInfo(int no){
		Dbcp dc = new Dbcp();
		Dto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "SELECT n.no, n.title, n.content, n.regdt, s.sname, n.cnt 	"
				+ "		FROM notice n, STAFF s 								"
				+ "	   WHERE n.WRITER = s.sno 								"
				+ "		 AND N.NO = ?										";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto = new Dto();
				dto.setNo(rs.getShort("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setnRegDt(rs.getString("regdt"));
				dto.setsName(rs.getString("sname"));
				dto.setCnt(rs.getInt("cnt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void cnt (int no){
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE NOTICE SET cnt = cnt + 1 WHERE NO = ?";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);
		}
		
	}
	public void updateNotice (Dto dto) {
		Dbcp dc = new  Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update notice set title = ?, content = ? where no = ?";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);
		}
	}
	public void deleteNotice(String no){
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update notice set delyn = 'y' where no = ?";
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dc.close(null, pstmt, conn);
		}
	}
	
	public void noticeRe(Dto dt){
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into comments(no, seq, reply, writer)						"
				+ "values(		?																"
				+ "			,	(SELECT NVL((max(seq) +1) ,1) FROM comments WHERE no = ?)		"
				+ "			,	?																"
				+ "			,	?						)										";
		
		
		
		try{
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dt.getNo());
			pstmt.setInt(2, dt.getNo());
			pstmt.setString(3, dt.getReply());
			pstmt.setString(4, dt.getsNo());
			pstmt.executeUpdate();
			dbc.close(null, pstmt, conn);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbc.close(null, pstmt, conn);
		}
	}
	
	public List<Dto> noticeResel(int no){
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dto> li = new ArrayList<Dto>();
		Dto dto;
		String sql = "select sname as writer, no, reply, to_char(c.regdt,'yy-mm-dd hh24:mm:ss') as regdt, seq from comments c ,staff s where no=? "
				+ " and  c.delyn = 'N' and sno = writer order by seq desc";
		try{
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto = new Dto();
				dto.setWriter(rs.getString("writer"));
				dto.setNo(rs.getInt("no"));
				dto.setSeq(rs.getInt("seq"));
				dto.setReply(rs.getString("reply"));
				dto.setRegDt(rs.getString("regdt"));
				li.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbc.close(rs, pstmt, conn);
		}
		return li;
	}
	
	public Dto replyAjax(String no){
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dto dto = null;
		String sql = "select sname as writer, no, reply, to_char(c.regdt,'yy-mm-dd hh24:mm:ss') as regdt, seq from comments c ,staff s where no=? "
				+ " and  c.delyn = 'N' and sno = writer and seq = (select max(seq) from comments where no=?)";
		
		
		
		try{
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto = new Dto();
				dto.setWriter(rs.getString("writer"));
				dto.setNo(rs.getInt("no"));
				dto.setSeq(rs.getInt("seq"));
				dto.setReply(rs.getString("reply"));
				dto.setRegDt(rs.getString("regdt"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbc.close(rs, pstmt, conn);
		}
		return dto;
	}
//	10개씩 분할 페이징
	public List<Dto> pagingNoticeList (int start, int end) {
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dto dto = null;
		List<Dto> li = new ArrayList<>();
		TimeCheck tc = new TimeCheck();
		
		String sql = "select no, title, to_char(regdt, 'yyyy-mm-dd') as regdt, cnt 			"
				+ "	, (SELECT COUNT(seq) FROM comments WHERE NO = b.no AND delyn = 'N') AS comcnt 	"
				+ "		from (select rownum r, a.* from 											"
				+ "			 (select * from notice where delyn = 'N' order by no desc)a)b  			"
				+ "		where r between ? and ?										";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto = new Dto();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setnRegDt(rs.getString("regdt"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setLatest(tc.timeCheck(rs.getString("regdt")));
				dto.setComcnt(Integer.parseInt(rs.getString("comcnt")));
				
				li.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return li;
	}
//	로우 개수 구하기
	public int getTotalRecord() {
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalRecord = 0;
		String sql = "select count(*) from notice";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalRecord = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return totalRecord;
	}
}
