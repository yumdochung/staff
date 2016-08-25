package com.project001.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project001.common.Dbcp;
import com.project001.project.dto.ProjectDTO;


public class ProjectDAO {

	private static ProjectDAO instance = new ProjectDAO();
	
	public static ProjectDAO getInstance() {
		return instance;
	}
	
//	c Read u d
//	프로젝트 리스트
	public List<ProjectDTO> select() {
		Dbcp dbc = new Dbcp();
		List<ProjectDTO> list = new ArrayList<ProjectDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select prjtno, prjtnm, to_char(enddt, 'yyyy-mm-dd') as enddt			"
				   + ", to_char(regdt, 'yyyy-mm-dd') as regdt,								"
				   + " CASE WHEN enddt > sysdate THEN '진행중'								"
				   + " WHEN enddt = SYSDATE THEN '진행중'										"
				   + " WHEN enddt < sysdate THEN '프로젝트종료'									"
	           	   + " END AS status														"
				   + "  from (select * from project order by regdt desc)					"
				   + " where delyn = 'Y'													"
				   + " order by startdt desc												";
		
		
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProjectDTO pdto = new ProjectDTO();
				pdto.setPrjtno(Integer.parseInt(rs.getString("prjtno")));
				pdto.setPrjtnm(rs.getString("prjtnm"));
				pdto.setEnddt(rs.getString("enddt"));
				pdto.setRegdt(rs.getString("regdt"));
				pdto.setStatus(rs.getString("status"));
				
				list.add(pdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
//	Create r u d
//	프로젝트 등록
	public ProjectDTO insert(ProjectDTO pdto) {
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into project (prjtno, prjtnm, prjtcontent, prjtskill	"
				   + "					, writer, startdt, enddt, ordernm)			"
				   + "values ( (select nvl(max(prjtno) +1, 1) from project)			"
				   + "				,	?											"
				   + "				,	?											"
				   + "				,	?											"
				   + "				,	?											"
				   + "				,	?											"
				   + "				,	?											"
				   + "				,	?	)										";
		
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdto.getPrjtnm());
			pstmt.setString(2, pdto.getPrjtcontent());
			pstmt.setString(3, pdto.getPrjtskill());
			pstmt.setString(4, pdto.getWriter());
			pstmt.setString(5, pdto.getStartdt());
			pstmt.setString(6, pdto.getEnddt());
			pstmt.setString(7, pdto.getOrdernm());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close(null, pstmt, conn);
		}
		return pdto;
	}
	
//	Create r u d
//	프로젝트에 참여하는 사원
	public ProjectDTO stf_insert(ProjectDTO pdto) {
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into staff_project (prjtno, sno, spwriter, rolecd)	"
				   + " values( ?, ? ,? ,?	)									";
		
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdto.getPrjtno());
			pstmt.setString(2, pdto.getSno());
			pstmt.setString(3, pdto.getWriter());
			pstmt.setString(4, pdto.getRolecd());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(null, pstmt, conn);
		}
		
		return pdto;
	}
	
//	c Read u d
//	프로젝트에 참여하는 사원의 view
	public ProjectDTO staff_view(ProjectDTO pdto) {
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String view_sql = "select * from prjt_staff where sno = ?	";
		
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(view_sql);
			pstmt.setString(1, pdto.getSno());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				pdto.setSname(rs.getString("sname"));
				pdto.setDeptname(rs.getString("deptname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(rs, pstmt, conn);
		}
		
		return pdto;
	}
//	c Read u d
//	프로젝트 상세 보기
	public ProjectDTO info(int prjtno) {
		Dbcp dbc = new Dbcp();
		ProjectDTO pdto = new ProjectDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String info_sql = "select prjtno, writer, prjtnm, to_char(startdt, 'yyyy-mm-dd') as startdt			"
						+ "		, to_char(enddt, 'yyyy-mm-dd') as enddt	,ordernm, prjtskill, prjtcontent	"
						+ "  from project where prjtno = ?													";
		
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(info_sql);
			pstmt.setInt(1, prjtno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pdto.setPrjtno(rs.getInt("prjtno"));
				pdto.setWriter(rs.getString("writer"));
				pdto.setPrjtnm(rs.getString("prjtnm"));
				pdto.setStartdt(rs.getString("startdt"));
				pdto.setEnddt(rs.getString("enddt"));
				pdto.setOrdernm(rs.getString("ordernm"));
				pdto.setPrjtskill(rs.getString("prjtskill"));
				pdto.setPrjtcontent(rs.getString("prjtcontent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(rs, pstmt, conn);
		}
		return pdto;
	}
//프로젝트 상세보기 내 참여사원 정보
	public List<ProjectDTO> infoStaff(int prjtno){
		Dbcp dbc = new Dbcp();
		List<ProjectDTO> li = new ArrayList<ProjectDTO>();
		ProjectDTO dto;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String rcd = null;
		String info_sql = "SELECT sno,sname,deptname,rolecd FROM DAMO_STFSTATUS where prjtno = ?";
		
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(info_sql);
			pstmt.setInt(1, prjtno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				switch (rs.getString("rolecd")) {
				case "00  ":
					rcd="DEV";
					break;
				case "01  ":
					rcd="PL";
					break;
				case "10  ":
					rcd="PM";
					break;
				case "11  ":
					rcd="PMO";
					break;
				case "21  ":
					rcd="SALES";
					break;
				}
				dto = new ProjectDTO();
				dto.setSno(rs.getString("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setDeptname(rs.getString("deptname"));
				dto.setRolecd(rcd);
				
				li.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(rs, pstmt, conn);
		}
		return li;
	}
	
//	c Read u d
//	프로젝트 조회 list
	public List<ProjectDTO> search(String writer, String startdt1, String startdt2, String prjtnm) {
		Dbcp dbc = new Dbcp();
		List<ProjectDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("결과 : " +writer+startdt1+startdt2+prjtnm);
		
		String sql = "select writer, to_char(regdt,'yyyy-mm-dd') as regdt,"
					+ " prjtnm, to_char(enddt,'yyyy-mm-dd') as enddt, 	"
					+ " CASE WHEN enddt > sysdate THEN '진행중'								"
					+ " WHEN enddt = SYSDATE THEN '진행중'										"
					+ " WHEN enddt < sysdate THEN '프로젝트종료'									"
	           	   	+ " END AS status														"
	           	   	+ " from project where ";

		if (writer != null && !writer.equals("")) {
			sql = sql + " writer like '%'||'" + writer + "'||'%' or ";
		}
		if (startdt1 != null && !startdt1.equals("") && startdt2 != null
				&& !startdt2.equals("")) {
			sql = sql + " regdt between to_date(" + startdt1
					+ ",'yyyy/mm/dd') and to_date(" + startdt2
					+ ",'yyyy/mm/dd') or ";
		}
		if (prjtnm != null && !prjtnm.equals("")) {
			sql = sql + " prjtnm like '%'||'" + prjtnm + "'|| '%' ";
		}
		if (!writer.equals("") || !startdt1.equals("") || !startdt2.equals("")) {
			sql = sql.substring(0, sql.length() - 3);
		}
		if(writer.equals("") && startdt1.equals("") && startdt2.equals("") && prjtnm.equals("")){
			sql = sql+" 1 = 1";
		}
		sql = sql+"  order by enddt desc";
		System.out.println(sql);
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProjectDTO pdto = new ProjectDTO();
				pdto.setPrjtnm(rs.getString("prjtnm"));
				pdto.setEnddt(rs.getString("writer"));
				pdto.setRegdt(rs.getString("regdt"));
				pdto.setEnddt(rs.getString("enddt"));
				pdto.setStatus(rs.getString("status"));
				
				list.add(pdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
//	c r Update d
//	프로젝트 수정
	public void update(ProjectDTO pdto) {
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String update_sql = "update project set prjtnm = ?, startdt = ?, enddt = ?	"
						  + "	  , ordernm = ?, prjtskill = ? , prjtcontent = ?	"
						  + " where prjtno = ?										";
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, pdto.getPrjtnm());
			pstmt.setString(2, pdto.getStartdt());
			pstmt.setString(3, pdto.getEnddt());
			pstmt.setString(4, pdto.getOrdernm());
			pstmt.setString(5, pdto.getPrjtskill());
			pstmt.setString(6, pdto.getPrjtcontent());
			pstmt.setInt(7, pdto.getPrjtno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(null, pstmt, conn);
		}
	}
	
	public ProjectDTO prjtnosearch(){
		ProjectDTO dto = null;
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement("select prjtno,writer from (select prjtno,writer from project order by regdt desc) where rownum = 1");
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto = new ProjectDTO();
				dto.setPrjtno(rs.getInt(1));
				dto.setWriter(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(rs, pstmt, conn);
		}
		return dto;
	}
	
//	c r u Delete
//	프로젝트 수행
	public void prjt_del(int prjtno) {
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String del_sql = "update project set delyn = 'N'	"
					   + " where prjtno = ?					";
		
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(del_sql);
			pstmt.setInt(1, prjtno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(null, pstmt, conn);
		}
	}
	
//	c r u Delete
//	프로젝트 참여 사원 삭제
	public void st_prjt_del(int prjtno, String sno) {
		Dbcp dbc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String del_sql = "update staff_project set delyn = 'Y'	"
					   + " where prjtno = ?						"
					   + "   and sno = ?						";
		
		try {
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(del_sql);
			pstmt.setInt(1, prjtno);
			pstmt.setString(2, sno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.close(null, pstmt, conn);
		}
	}
	public List<ProjectDTO> selectProjectList (int start, int end) {
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectDTO dto = null;
		List<ProjectDTO> li = new ArrayList<>();
//		String sql = "select prjtno, prjtnm, to_char(enddt, 'yyyy-mm-dd') as enddt			"
//		   + ", to_char(regdt, 'yyyy-mm-dd') as regdt								"
//		   + "  from (select * from project order by regdt desc)					"
//		   + " where delyn = 'Y'													"
//		   + " order by startdt desc												";
		
		String sql = "select prjtno, prjtnm, to_char(enddt, 'yyyy-mm-dd') as enddt 					"
				+ "		, to_char(regdt, 'yyyy-mm-dd') as regdt,									"
				+ " CASE WHEN enddt > sysdate THEN '진행중'								"
				+ " WHEN enddt = SYSDATE THEN '진행중'										"
				+ " WHEN enddt < sysdate THEN '프로젝트종료'									"
	           	+ " END AS status														"
				+ "		from (select rownum r, a.* from 											"
				+ "			 (select * 																"
				+ "		from project where delyn = 'Y' order by regdt desc)a)  										"
				+ "		where r between ? and ?										";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto = new ProjectDTO();
				dto.setPrjtno(rs.getInt("prjtno"));
				dto.setPrjtnm(rs.getString("prjtnm"));
				dto.setEnddt(rs.getString("enddt"));
				dto.setRegdt(rs.getString("regdt"));
				dto.setStatus(rs.getString("status"));
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
		String sql = "select count(*) from project";
		
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
	
	public List<ProjectDTO> insertStaffToProject (String skill){
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectDTO dto = null;
		List<ProjectDTO> li = new ArrayList<>();		
		String sql = "select sno, sname, deptname, skill, jobname from damo_prjt where skill like '%'||'" + skill + "'||'%'";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new ProjectDTO();
				dto.setSno(rs.getString("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setDeptname(rs.getString("deptname"));
				dto.setSkill(rs.getString("skill"));
				dto.setJobname(rs.getString("jobname"));
				li.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return li;
	}
	
//	사원 세부정보 추가
	public void insertProjectStaff (ProjectDTO dto){
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into staff_project (prjtno, sno, spwriter, rolecd)		"
				+ "						values (?, ?, ?, ?)							";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getPrjtno());
			pstmt.setString(2, dto.getSno());
			pstmt.setString(3, dto.getSpwriter());
			pstmt.setString(4, dto.getRolecd());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);
		}
		
	}
//	사원 세부정보 추가 확인
	public ProjectDTO selectForInsertProjectStaff (String sno) {
		Dbcp dc = new Dbcp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectDTO sdto = null;
		
		String sql = "select s.sno, s.sname, d.deptname, sp.rolecd 	"
				+ "		from staff s, sdept d, STAFF_PROJECT sp 	"
				+ "	   where s.deptcd = d.deptcd 					"
				+ "		 AND s.sno = sp.sno 						"
				+ "		 AND s.sno = ? 								";
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sdto = new ProjectDTO();
				sdto.setSno(rs.getString("sno"));
				sdto.setSname(rs.getString("sname"));
				sdto.setDeptname(rs.getString("deptname"));
				sdto.setRolecd(rs.getString("rolecd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return sdto;
	}
		
}