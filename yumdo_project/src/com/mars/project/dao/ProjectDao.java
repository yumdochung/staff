package com.mars.project.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mars.common.DBManager;
import com.mars.project.dto.ProjectDto;



public class ProjectDao {
	private ProjectDao(){
		
	}
	
	private static ProjectDao instance = new ProjectDao();
	
	public static ProjectDao getInstance(){
		if(instance == null){
			instance = new ProjectDao();
		}
		return instance;
	}
	
	public List<ProjectDto> selectAllProjects(){
		String sql = "select * from project p, staff s where p.sid=s.sid order by num desc ";
		
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				ProjectDto pt = new ProjectDto();
				
				pt.setNum(rs.getInt("num"));
				pt.setSnm(rs.getString("snm"));
				pt.setStartterm(rs.getString("startterm"));
				pt.setEndterm(rs.getString("endterm"));
				pt.setPass(rs.getString("pass"));
				pt.setTitle(rs.getString("title"));
				pt.setContent(rs.getString("content"));
				pt.setSkill(rs.getString("skill"));
				pt.setReadcount(rs.getInt("readcount"));
				pt.setRegdt(rs.getString("regdt"));
				
				list.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, stmt, conn);
		}
		return list;
	}
	
	public void insertProject(ProjectDto pt){
		String sql = "insert into project("
				+"num, sid, startterm, endterm, pass, title, content, skill) " + "values(project_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pt.getSid());
			pstmt.setString(2, pt.getStartterm());
			pstmt.setString(3, pt.getEndterm());
			pstmt.setString(4, pt.getPass());
			pstmt.setString(5, pt.getTitle());
			pstmt.setString(6, pt.getContent());
			pstmt.setString(7, pt.getSkill());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void updateReadCount(String num){
		String sql = "update project set readcount=readcount+1 where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ProjectDto selectOneProjectByNum(String num) {
		String sql = "select * from project p, staff s where num = ? and p.sid=s.sid";
		
		ProjectDto pt = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()){
				pt = new ProjectDto();
				
				pt.setNum(rs.getInt("num"));
				pt.setSnm(rs.getString("snm"));
				pt.setPass(rs.getString("pass"));
				pt.setStartterm(rs.getString("startterm"));
				pt.setEndterm(rs.getString("endterm"));
				pt.setTitle(rs.getString("title"));
				pt.setContent(rs.getString("content"));
				pt.setSkill(rs.getString("skill"));
				pt.setRegdt(rs.getString("regdt"));
				pt.setReadcount(rs.getInt("readcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return pt;
	
}
	public void updateProject(ProjectDto pt) {
		String sql = "update project set snm=?, startterm=?, endterm=?, pass=?, skill=?"
				+ "title=?, content=? where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pt.getSnm());
			pstmt.setString(2, pt.getStartterm());
			pstmt.setString(3, pt.getEndterm());
			pstmt.setString(4, pt.getPass());
			pstmt.setString(5, pt.getSkill());
			pstmt.setString(6, pt.getTitle());
			pstmt.setString(7, pt.getContent());
			pstmt.setInt(8, pt.getNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ProjectDto checkPassWord(String pass, String num){
		String sql = "select * from project p, staff s where pass=? and num=? and p.sid=s.sid";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectDto pt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()){
				pt = new ProjectDto();
				
				pt.setNum(rs.getInt("num"));
				pt.setSnm(rs.getString("snm"));
				pt.setStartterm(rs.getString("startterm"));
				pt.setEndterm(rs.getString("endterm"));
				pt.setPass(rs.getString("pass"));
				pt.setTitle(rs.getString("title"));
				pt.setContent(rs.getString("content"));
				pt.setSkill(rs.getString("skill"));
				pt.setReadcount(rs.getInt("readcount"));
				pt.setRegdt(rs.getString("regdt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pt;
	}
	public void deleteProject(String num) {
		String sql = "delete project where num=?";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}