package com.mars.dto;

public class Dto {

	
	//사원 Staff Dto
	private String sid;			//사원ID
	private String spwd;		//비밀번호
	private String sno;			//사원번호
	private String snm; 		//이름
	private String jumin; 		//주민번호
	private String imgfile; 	//사진경로
	private String deptno;			//부서코드
	private String jobcd; 	  	    //직급코드
	private String zipcode;		//우편번호
	private String addr1;		//기본주소
	private String addr2;		//상세주소
	private String email;		//이메일
	private String sphone;		//연락처
	private String salary;			//연봉
	private String joindt; 		//입사일
	private String outdt;		//퇴사일
	private int admin;			//관리자
	private String regdt;		//등록일
	private String delyn;		//사원 퇴사여부
	private String workingyn;	//프로젝트참여여부
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSnm() {
		return snm;
	}
	public void setSnm(String snm) {
		this.snm = snm;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getImgfile() {
		return imgfile;
	}
	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getJobcd() {
		return jobcd;
	}
	public void setJobcd(String jobcd) {
		this.jobcd = jobcd;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getJoindt() {
		return joindt;
	}
	public void setJoindt(String joindt) {
		this.joindt = joindt;
	}
	public String getOutdt() {
		return outdt;
	}
	public void setOutdt(String outdt) {
		this.outdt = outdt;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getDelyn() {
		return delyn;
	}
	public void setDelyn(String delyn) {
		this.delyn = delyn;
	}
	public String getWorkingyn() {
		return workingyn;
	}
	public void setWorkingyn(String workingyn) {
		this.workingyn = workingyn;
	}
	@Override
	public String toString() {
		return "Dto [snm=" + snm + ", sid=" + sid + ", spwd=" + spwd + ", email=" + email + ", sphone="
				+ sphone + ", admin=" + admin + "]";
	}

	private String SIDO;
	private String GUGUN;			
	private String DONG;			
	private String RI;			
	private String BLDG;			
	private String BUNGI;			
	private String SEQ;
	public String getSIDO() {
		return SIDO;
	}
	public void setSIDO(String sIDO) {
		SIDO = sIDO;
	}
	public String getGUGUN() {
		return GUGUN;
	}
	public void setGUGUN(String gUGUN) {
		GUGUN = gUGUN;
	}
	public String getDONG() {
		return DONG;
	}
	public void setDONG(String dONG) {
		DONG = dONG;
	}
	public String getRI() {
		return RI;
	}
	public void setRI(String rI) {
		RI = rI;
	}
	public String getBLDG() {
		return BLDG;
	}
	public void setBLDG(String bLDG) {
		BLDG = bLDG;
	}
	public String getBUNGI() {
		return BUNGI;
	}
	public void setBUNGI(String bUNGI) {
		BUNGI = bUNGI;
	}
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	
	
	
}
