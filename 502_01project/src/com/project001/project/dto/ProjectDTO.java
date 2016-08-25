package com.project001.project.dto;

public class ProjectDTO {
	
//	프로젝트 DTO
	private int prjtno = 0;						// 프로젝트 번호
	private String prjtnm = null;				// 프로젝트 제목
	private String prjtcontent = null;			// 프로젝트 상세내용
	private String prjtskill = null;			// 프로젝트 필요기술
	private String writer = null;				// 프로젝트 작성자
	private String startdt = null;				// 프로젝트 시작일
	private String enddt = null;				// 프로젝트 마감일
	private String ordernm = null;				// 프로젝트 발주처
	private String regdt = null;				// 프로젝트 등록일
	private String updt = null;					// 프로젝트 수정일
	private String delyn = null;				// 프로젝트 수행 여부 ('Y' 수행중// 'N' 미수행중)

	//	프로젝트 참여 사원 DTO
	private String sno = null;
	private String spwriter = null;
	private String rolecd = null;
	
//	프로젝트 참여 사원 view DTO
	private String deptname = null;
	private String sname = null;
	private String skill = null;
	private String jobname = null;
	
//	프로젝트 상태
	private String status = null;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public int getPrjtno() {
		return prjtno;
	}
	public void setPrjtno(int prjtno) {
		this.prjtno = prjtno;
	}
	public String getPrjtnm() {
		return prjtnm;
	}
	public void setPrjtnm(String prjtnm) {
		this.prjtnm = prjtnm;
	}
	public String getPrjtcontent() {
		return prjtcontent;
	}
	public void setPrjtcontent(String prjtcontent) {
		this.prjtcontent = prjtcontent;
	}
	public String getPrjtskill() {
		return prjtskill;
	}
	public void setPrjtskill(String prjtskill) {
		this.prjtskill = prjtskill;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getStartdt() {
		return startdt;
	}
	public void setStartdt(String startdt) {
		this.startdt = startdt;
	}
	public String getEnddt() {
		return enddt;
	}
	public void setEnddt(String enddt) {
		this.enddt = enddt;
	}
	public String getOrdernm() {
		return ordernm;
	}
	public void setOrdernm(String ordernm) {
		this.ordernm = ordernm;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getUpdt() {
		return updt;
	}
	public void setUpdt(String updt) {
		this.updt = updt;
	}
	public String getDelyn() {
		return delyn;
	}
	public void setDelyn(String delyn) {
		this.delyn = delyn;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSpwriter() {
		return spwriter;
	}
	public void setSpwriter(String spwriter) {
		this.spwriter = spwriter;
	}
	public String getRolecd() {
		return rolecd;
	}
	public void setRolecd(String rolecd) {
		this.rolecd = rolecd;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
}