package com.mars.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mars.common.DBManager;
import com.mars.dto.Dto;


public class StaffDao {
	private StaffDao(){
	}
	
	private static StaffDao instance = new StaffDao();
	public static StaffDao getInstance() {
		return instance;
	}
	//사원 리스트 메소드
	public List<Dto> selectAllStaff(){
		String sql= "select * from staff order by sid desc";
		
		List<Dto> list = new ArrayList<>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn= DBManager.getConnection();
			stmt= conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Dto st = new Dto();
				
				st.setJoindt(rs.getString("joindt"));
				st.setSnm(rs.getString("snm"));
				st.setJobcd(rs.getString("jobcd"));
				st.setSphone(rs.getString("sphone"));
				st.setEmail(rs.getString("email"));
				
				list.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, stmt, conn);
		}
		
		return list;
	}
	
	
		//사용자 인증시 사용하는 메소드 (로그인)
		public int loginCheck(String sid, String spwd) {
			int result = -1;
			String sql = "select spwd from staff where sid=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sid);
				rs = pstmt.executeQuery();
				if (rs.next()){
					if (rs.getString("spwd") !=null && rs.getString("spwd").equals(spwd)) {
						result = 1;
					} else {
						result = 0;
					}
				} else{
					result = -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		


		//아이디로 회원 정보 가져오는 메소드
		public Dto getStaff(String sid) {
			Dto st = null;
			String sql = "select * from staff where sid=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sid);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					st = new Dto();
					st.setSnm(rs.getString("snm"));
					st.setSid(rs.getString("sid"));
					st.setSpwd(rs.getString("spwd"));
					st.setEmail(rs.getString("email"));
					st.setSphone(rs.getString("sphone"));
					st.setAdmin(rs.getInt("admin"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			return st;
		}
		public int confirmID(String sid){
			int result = -1;
			String sql = "select sid from staff where sid=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sid);
				rs = pstmt.executeQuery();
				if (rs.next()){
					result = 1;
				} else {
					result = -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			return result;
		}
		
		//회원가입
		public int insertMember(Dto st){
			int result = -1;
			String sql = "insert into staff (snm, sid, spwd, email, sphone, jumin, zipcode, addr1, addr2)values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, st.getSnm());
				pstmt.setString(2, st.getSid());
				pstmt.setString(3, st.getSpwd());
				pstmt.setString(4, st.getEmail());
				pstmt.setString(5, st.getSphone());
				pstmt.setString(6, st.getJumin());
				pstmt.setString(7, st.getZipcode());
				pstmt.setString(8, st.getAddr1());
				pstmt.setString(9, st.getAddr2());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		
		//회원수정
		public int updateMember(Dto st){
			int result = -1;
			String sql = "update staff set spwd=?, email=?,"
					  + "sphone=?, jumin=?, zipcode=?, addr1=?, addr2=? where sid=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, st.getSpwd());
				pstmt.setString(2, st.getEmail());
				pstmt.setString(3, st.getSphone());
				pstmt.setString(4, st.getJumin());
				pstmt.setString(5, st.getZipcode());
				pstmt.setString(6, st.getAddr1());
				pstmt.setString(7, st.getAddr2());
				pstmt.setString(8, st.getSid());
				result = pstmt.executeUpdate();
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null)	pstmt.close();
					if(conn != null)	conn.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			return result;
		}
		//사원정보를 출력하기 위한 메소드
		public Dto getStafflist(String sid) {
			Dto st = null;
			String sql = "select * from staff where sid=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sid);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					st = new Dto();
					st.setJoindt(rs.getString("joindt"));
					st.setSnm(rs.getString("snm"));
					st.setSid(rs.getString("sid"));
					st.setJobcd(rs.getString("jobcd"));
					st.setSphone(rs.getString("sphone"));
					st.setEmail(rs.getString("email"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			return st;
		}
		
		///////////////////////zipcode//////////////////////////
		public List<Dto> zip(String dong){
			DBManager db = new DBManager();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Dto> li = new ArrayList<Dto>();
			Dto dto = null;
			String sql = "SELECT zipcode,sido,gugun,dong,seq,NVL(ri,' ') AS ri,NVL(bldg,' ') AS bldg,NVL(bungi,' ') AS bungi FROM zipcode WHERE dong like '%'|| ? ||'%'";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dong);
				rs = pstmt.executeQuery();
				while(rs.next()){
					dto = new Dto();
					dto.setZipcode(rs.getString("zipcode"));
					dto.setSIDO(rs.getString("SIDO"));
					dto.setGUGUN(rs.getString("GUGUN"));
					dto.setDONG(rs.getString("DONG"));
					dto.setRI(rs.getString("RI"));
					dto.setBLDG(rs.getString("BLDG"));
					dto.setBUNGI(rs.getString("BUNGI"));
					
					
					li.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBManager.close(rs, pstmt, conn);
			}
			return li;
		}
	}
