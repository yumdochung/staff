package com.project001.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project001.common.Dbcp;
import com.project001.common.dto.Dto;

public class StaffDao {
	private StaffDao() {
	}

	private static StaffDao instance = new StaffDao();

	public static StaffDao getInstance() {
		return instance;
	}

	public String loginCheck(String id) {
		Dbcp dc = new Dbcp();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userpwd = null;
		String sql = "select userpwd from staff where sno = ? and delyn='N'";

		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userpwd = rs.getString("userpwd");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return userpwd;

	}

	public List<Dto> selectAllStaff() {
		Dbcp dc = new Dbcp();
		List<Dto> li = new ArrayList<Dto>();
		Dto st = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select sno, sname, jobcd, to_char(regdt, 'yyyy-mm-dd) as regdt "
				+ "from staff where delyn = 'N' order by regdt desc";

		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				st = new Dto();
				st.setsNo(rs.getString("sno"));
				st.setsName(rs.getString("sname"));
				st.setJobCd(rs.getString("jobcd"));
				st.setRegDt(rs.getString("regdt"));
				li.add(st);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return li;
	}

	public List<Dto> selectStaffByKeyword(String sNo, String joinDt1,
			String joinDt2, String sName) {
		Dbcp dc = new Dbcp();
		Dto sdt = null;
		List<Dto> li = new ArrayList<>();
		String sql = "select sname, jobcd, to_char(regdt, 'yyyy-mm-dd') as regdt"
					+ " from staff where ";

		if (sNo != null && !sNo.equals("")) {
			sql = sql + " sno like '%'||'" + sNo + "'||'%' or ";
		}
		if (joinDt1 != null && !joinDt1.equals("") && joinDt2 != null
				&& !joinDt2.equals("")) {
			sql = sql + " regdt between to_date(" + joinDt1
					+ ",'yyyy/mm/dd') and to_date(" + joinDt2
					+ ",'yyyy/mm/dd') or ";
		}
		if (sName != null && !sName.equals("")) {
			sql = sql + " sname like '%'||'" + sName + "'||'%' ";
		}
		if (!sNo.equals("") || !joinDt1.equals("") || !joinDt2.equals("")) {
			sql = sql.substring(0, sql.length() - 3);
		}
		if (sNo.equals("") && joinDt1.equals("") && joinDt2.equals("") && sName.equals("")) {
			sql = sql + "  1 = 1";
		}
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				sdt = new Dto();
				sdt.setsName(rs.getString("sname"));
				sdt.setJobCd(rs.getString("jobcd"));
				sdt.setRegDt(rs.getString("regdt"));
				li.add(sdt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return li;

	}

	public void insertStaff(String pictureUrl, String sName, String jumin1, String jumin2,
			String gendercd, String email, String sPhone, String deptCd,
			String jobCd, String zipCode, String addr1, String addr2,
			String sal, String skill) {
		Dbcp dc = new Dbcp();

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into staff (pictureUrl, sNo, sName, jumin1, jumin2, gendercd, email, sPhone, deptCd, jobCd, zipCode, addr1, addr2, skill, userpwd)"
				+ "		values (?,(SELECT TO_CHAR(SYSDATE,'YYYYMM')||NVL(LPAD(TO_CHAR(MAX(TO_NUMBER(SUBSTR(SNO,7,4))) + 1),4,'0'),'0001')	"
				+ " 			FROM STAff WHERE SNO LIKE TO_CHAR(sysdate,'YYYYMM')||'%') , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		String salSql = "insert into staff_sal_his (sno, seq, sal) values((select sno from (select sno from staff order by regdt desc) where rownum = 1)	"
				+ "										 				 ,(SELECT NVL(MAX(seq) +1, 1) FROM staff_sal_his where sno=(select sno from (select sno from staff order by regdt desc) where rownum=1))"
				+ "										 				 , ?																			"
				+ "														 ) 																				";

		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pictureUrl);
			pstmt.setString(2, sName);
			pstmt.setString(3, jumin1);
			pstmt.setString(4, jumin2);
			pstmt.setString(5, gendercd);
			pstmt.setString(6, email);
			pstmt.setString(7, sPhone);
			pstmt.setString(8, deptCd);
			pstmt.setString(9, jobCd);
			pstmt.setString(10, zipCode);
			pstmt.setString(11, addr1);
			pstmt.setString(12, addr2);
			pstmt.setString(13, skill);
			pstmt.setString(14, jumin2);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);
		}

		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(salSql);
			pstmt.setString(1, sal);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);

		}

	}

	
	
	public Dto infoStaff(String sNo) {

		Dbcp dc = new Dbcp();
		Dto sdt = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		String sql = "select pictureurl, sno, sname, jumin1, jumin2, gendercd, email, sphone 	"
           +"	    , deptname, jobname, joindt, retiredt, zipcode, addr1, addr2, sal, skill  	"
           +"		, regdt																		"
           +"		  from damo_staff															"
           + "		  where sno = ?																";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sdt = new Dto();
				sdt.setPictureUrl(rs.getString("pictureurl"));
				sdt.setsNo(rs.getString("sno"));
				sdt.setsName(rs.getString("sname"));
				sdt.setJumin1(rs.getString("jumin1"));
				sdt.setJumin2(rs.getString("jumin2"));
				sdt.setGenderCd(rs.getString("gendercd"));
				sdt.setEmail(rs.getString("email"));
				sdt.setsPhone(rs.getString("sphone"));
				sdt.setDeptName(rs.getString("deptname"));
				sdt.setJobName(rs.getString("jobname"));
				sdt.setJoinDt(rs.getString("joindt"));
				if (rs.getString("retiredt") == null || rs.getString("retiredt") == ""){
					sdt.setRetireDt("-");
				} else {
					sdt.setRetireDt(rs.getString("retiredt"));
				}
				sdt.setZipCode(rs.getString("zipcode"));
				sdt.setAddr1(rs.getString("addr1"));
				sdt.setAddr2(rs.getString("addr2"));
				sdt.setSal(rs.getString("sal"));
				sdt.setSkill(rs.getString("skill"));
				sdt.setRegDt(rs.getString("regdt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		return sdt;
		
	}
	
	public void updateStaff (Dto sdt){
		Dbcp dc = new Dbcp();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update staff set sno = ?, sname = ?, jumin1 = ?, jumin2 = ?, gendercd = ?								"
				+ "	, email = ?, sphone = ?, deptcd = ?, jobcd = ?, joindt = to_date(?, 'yyyy-mm-dd hh24:mi:ss')			"
				+ "	, zipcode = ?, addr1 = ?, addr2 = ?, skill = ?, regdt = to_date(?, 'yyyy-mm-dd hh24:mi:ss'),pictureurl=?				"
				+ "	  where sno = ?																							";
		
		String salSql = "insert into staff_sal_his(sno,sal,seq) values(?, ?,(select nvl(max(seq)+1,1) from staff_sal_his where sno = ?))";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sdt.getsNo());
			pstmt.setString(2, sdt.getsName());
			pstmt.setString(3, sdt.getJumin1());
			pstmt.setString(4, sdt.getJumin2());
			pstmt.setString(5, sdt.getGenderCd());
			pstmt.setString(6, sdt.getEmail());
			pstmt.setString(7, sdt.getsPhone());
			pstmt.setString(8, sdt.getDeptCd());
			pstmt.setString(9, sdt.getJobCd());
			pstmt.setString(10, sdt.getJoinDt());
			pstmt.setString(11, sdt.getZipCode());
			pstmt.setString(12, sdt.getAddr1());
			pstmt.setString(13, sdt.getAddr2());
			pstmt.setString(14, sdt.getSkill());
			pstmt.setString(15, sdt.getRegDt());	
			pstmt.setString(16, sdt.getPictureUrl());
			pstmt.setString(17, sdt.getsNo());
		
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);
		}
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(salSql);
			pstmt.setString(1, sdt.getsNo());
			pstmt.setString(2, sdt.getSal());
			pstmt.setString(3, sdt.getsNo());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);
		}
	}
	
	public void deleteStaff(String sNo) {
		Dbcp dc = new Dbcp();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update staff set delyn = 'Y' where sno = ?";
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(null, pstmt, conn);
		}
	}
	
	public String getAdmin(String sNo){
		Dbcp dc = new Dbcp();
		String admin = null;
		
		String sql = "select admin from staff where sno = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			rs = pstmt.executeQuery();
			if(rs.next())admin = rs.getString("admin");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dc.close(rs, pstmt, conn);
		}
		
		return admin; 
	}

	
	// 사원 자격증 등록
		public Dto in_lic(Dto sdto) {
			Dbcp dbc = new Dbcp();
			Connection conn = null;
			PreparedStatement pstmt = null;

			String staff_lic = "insert into staff_lic(sno, seq, licnm, issue, issuedt, licpic)													"
					+ "values(																											"
					+ "	(select sno from (select sno from staff order by regdt desc) where rownum = 1)								"
					+ "			,	(SELECT NVL((max(seq) +1) ,1) FROM STAFF_lic 													"
					+ "				WHERE sno = (select sno from (select sno from staff order by regdt desc) where rownum = 1))		"
					+ "			,	?																								"
					+ "			,	?																								"
					+ "			,	?																								"
					+ "			,	?						)																		";

			try {
				conn = dbc.getConnection();
				pstmt = conn.prepareStatement(staff_lic);
				pstmt.setString(1, sdto.getLicnm());
				pstmt.setString(2, sdto.getIssue());
				pstmt.setString(3, sdto.getIssuedt());
				pstmt.setString(4, sdto.getLicpic());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbc.close(null, pstmt, conn);
			}

			return sdto;
		}

		// 사원 자격증 Read
		public List<Dto> out_lic(String sno) {
			Dbcp dbc = new Dbcp();
			List<Dto> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String staff_lic = "select licnm, issue, to_char(issuedt, 'yyyy-mm-dd') as issuedt , licpic		"
					+ "  from staff s, staff_lic sl												"
					+ " where s.sno = sl.sno														"
					+ "   and s.sno = ?															";

			try {
				conn = dbc.getConnection();
				pstmt = conn.prepareStatement(staff_lic);
				pstmt.setString(1, sno);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Dto sdto = new Dto();
					sdto.setLicnm(rs.getString("licnm"));
					sdto.setIssue(rs.getString("issue"));
					sdto.setIssuedt(rs.getString("issuedt"));
					sdto.setLicpic(rs.getString("licpic"));

					list.add(sdto);
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

		// 사원 경력 등록
		public Dto in_career(Dto sdto) {
			Dbcp dbc = new Dbcp();
			Connection conn = null;
			PreparedStatement pstmt = null;

			String staff_career = "insert into staff_career(sno, seq, prjtnm, prjtskill, startdt, enddt, ordernm, rolecd)						"
					+ "values(																										"
					+ "	(select sno from (select sno from staff order by regdt desc) where rownum = 1)								"
					+ "			,	(SELECT NVL((max(seq) +1) ,1) FROM STAFF_career 												"
					+ "				WHERE sno = (select sno from (select sno from staff order by regdt desc) where rownum = 1))		"
					+ "			,		?																							"
					+ "			,		?																							"
					+ "			,		?																							"
					+ "			,		?																							"
					+ "			,		?																							"
					+ "			,		?			)																				";

			try {
				conn = dbc.getConnection();
				pstmt = conn.prepareStatement(staff_career);
				pstmt.setString(1, sdto.getPrjtnm());
				pstmt.setString(2, sdto.getPrjtskill());
				pstmt.setString(3, sdto.getStartdt());
				pstmt.setString(4, sdto.getEnddt());
				pstmt.setString(5, sdto.getOrdernm());
				pstmt.setString(6, sdto.getRolecd());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbc.close(null, pstmt, conn);
			}
			return sdto;
		}

		// 사원 경력 read
		public List<Dto> out_career(String sno) {
			Dbcp dbc = new Dbcp();
			List<Dto> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String staff_career = "select prjtnm, prjtskill, to_char(startdt, 'yyyy-mm-dd') as startdt	"
					+ ", to_char(enddt, 'yyyy-mm-dd') as enddt, ordernm, rolecd				"
					+ " from staff s, staff_career sc										"
					+ " where s.sno = sc.sno												"
					+ "   and s.sno = ?														";

			try {
				conn = dbc.getConnection();
				pstmt = conn.prepareStatement(staff_career);
				pstmt.setString(1, sno);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Dto sdto = new Dto();
					sdto.setPrjtnm(rs.getString("prjtnm"));
					sdto.setPrjtskill(rs.getString("prjtskill"));
					sdto.setStartdt(rs.getString("startdt"));
					sdto.setEnddt(rs.getString("enddt"));
					sdto.setOrdernm(rs.getString("ordernm"));
					sdto.setRolecd(rs.getString("rolecd"));
					
					list.add(sdto);
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
		
//		사원 학력 등록
		public Dto in_aca(Dto sdto) {
			Dbcp dbc = new Dbcp();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String staff_aca = "insert into staff_aca(sno, seq, scd, scname, subjectnm, spic, entrancedt, graduatedt, graduateyn) "
					+ "values(															"
					+ "	(select sno from (select sno from staff order by regdt desc) where rownum = 1)									"
					+ "			,	(SELECT NVL((max(seq) +1) ,1) FROM STAFF_aca 														"
					+ "					WHERE sno = (select sno from (select sno from staff order by regdt desc) where rownum = 1))		"
					+ "			,	?																									"
					+ "			,	?																									"
					+ "			,	?																									"
					+ "			,	?																									"
					+ "			,	?																									"
					+ "			,	?																									"
					+ "			,	?			)																						";

			try {
				conn = dbc.getConnection();
				pstmt = conn.prepareStatement(staff_aca);
				pstmt.setString(1, sdto.getScd());
				pstmt.setString(2, sdto.getScname());
				pstmt.setString(3, sdto.getSubjectnm());
				pstmt.setString(4, sdto.getSpic());
				pstmt.setString(5, sdto.getEntrancedt());
				pstmt.setString(6, sdto.getGraduatedt());
				pstmt.setString(7, sdto.getGraduateyn());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbc.close(null, pstmt, conn);
			}
			return sdto;
		}
		
//		사원 학력 Read
		public List<Dto> out_aca(String sno) {
			Dbcp dbc = new Dbcp();
			List<Dto> list  = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String staff_aca = "select scd, scname, subjectnm, spic, to_char(entrancedt, 'yyyy-mm-dd') as entrancedt		"
					+ ", to_char(graduatedt, 'yyyy-mm-dd') as graduatedt, graduateyn										"
					+ "  from staff s, staff_aca sa																			"
					+ " where s.sno = sa.sno																				"
					+ "   and s.sno = ?																						";

			// 사원 학력
			try {
				conn = dbc.getConnection();
				pstmt = conn.prepareStatement(staff_aca);
				pstmt.setString(1, sno);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Dto sdto = new Dto();
					sdto.setScd(rs.getString("scd"));
					sdto.setScname(rs.getString("scname"));
					sdto.setSubjectnm(rs.getString("subjectnm"));
					sdto.setSpic(rs.getString("spic"));
					sdto.setEntrancedt(rs.getString("entrancedt"));
					sdto.setGraduatedt(rs.getString("graduatedt"));
					sdto.setGraduateyn(rs.getString("graduateyn"));
					
					list.add(sdto);
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
		
		public List<Dto> zip(String dong){
			Dbcp db = new Dbcp();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Dto> li = new ArrayList<Dto>();
			Dto dto = null;
			String sql = "select * from zipcode where dong like '%'|| ? ||'%'";
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dong);
				rs = pstmt.executeQuery();
				while(rs.next()){
					dto = new Dto();
					dto.setZipCode(rs.getString("zipcode"));
					dto.setSIDO(rs.getString("sido"));
					dto.setGUGUN(rs.getString("gugun"));
					dto.setDONG(rs.getString("dong"));
					dto.setRI(rs.getString("ri"));
					dto.setBLDG(rs.getString("bldg"));
					dto.setBUNGI(rs.getString("bungi"));
					li.add(dto);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				db.close(rs, pstmt, conn);
			}
			return li;
		}
	
//		10개씩 분할 페이징
		public List<Dto> selectStaffList (int start, int end) {
			Dbcp dc = new Dbcp();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Dto dto = null;
			List<Dto> li = new ArrayList<>();
			
			
			String sql = "select sno, sname, jobcd, to_char(regdt, 'yyyy-mm-dd') as regdt				"
					+ "		from (select rownum r, a.* from 											"
					+ "			 (select * 																"
					+ "		from staff where delyn = 'N' order by regdt desc)a)  											"
					+ "		where r between ? and ?										";
			
			try {
				conn = dc.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					dto = new Dto();
					dto.setsNo(rs.getString("sno"));
					dto.setsName(rs.getString("sname"));
					dto.setJobCd(rs.getString("jobcd"));
					dto.setRegDt(rs.getString("regdt"));
					li.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dc.close(rs, pstmt, conn);
			}
			return li;
		}
//		로우 개수 구하기
		public int getTotalRecord() {
			Dbcp dc = new Dbcp();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int totalRecord = 0;
			String sql = "select count(*) from staff";
			
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


