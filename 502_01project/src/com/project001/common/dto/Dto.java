package com.project001.common.dto;

public class Dto {
//	SNO	CHAR(10)
//	SNAME	VARCHAR2(20)
//	USERPWD	VARCHAR2(16)
//	EMAIL	VARCHAR2(50)
//	JUMIN1	CHAR(6)
//	JUMIN2	CHAR(7)
//	GENDERCD	CHAR(1)
//	SPHONE	VARCHAR2(13)
//	DEPTCD	CHAR(4)
//	DEPTNAME	VARCHAR2(20)
//	JOBCD	CHAR(4)
//	JOBNAME	VARCHAR2(20)
//	ROLECD	CHAR(4)
//	JOINDT	DATE
//	RETIREDT	DATE
//	ZIPCODE	CHAR(6)
//	ADDR1	VARCHAR2(50)
//	ADDR2	VARCHAR2(50)
//	SKILL	VARCHAR2(200)
//	PICTUREURL	VARCHAR2(60)
//	REGDT	DATE
//	UPDT	DATE
	private int comcnt;
	public int getComcnt() {
		return comcnt;
	}
	public void setComcnt(int comcnt) {
		this.comcnt = comcnt;
	}
	private String latest;
	public String getLatest() {
		return latest;
	}
	public void setLatest(String latest) {
		this.latest = latest;
	}
	private String sNo;
	private String sName;
	private String userPwd;
	private String email;
	private String jumin1;
	private String jumin2;
	private String genderCd;
	private String sPhone;
	private String deptCd;
	private String jobCd;
	private String jobName;
	private String joinDt;
	private String retireDt;
	private String zipCode;
	private String addr1;
	private String addr2;
	private String skill;
	private String pictureUrl;
	private String regDt;
	private String upDt;
	private String deptName;
//	전화번호 3단입력용 변수들
	private String hp1;
	private String hp2;
	private String hp3;
	
//	이메일 2단입력용 변수
	private String mail1;
	private String mail2;
	
	public String getMail1() {
		return mail1;
	}
	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}
	public String getMail2() {
		return mail2;
	}
	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	public String getHp3() {
		return hp3;
	}
	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	private String delYn;
	
//	급여테이블
	private String sal;
	
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJumin1() {
		return jumin1;
	}
	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}
	public String getJumin2() {
		return jumin2;
	}
	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}
	public String getGenderCd() {
		return genderCd;
	}
	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	public String getJobCd() {
		return jobCd;
	}
	public void setJobCd(String jobCd) {
		this.jobCd = jobCd;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJoinDt() {
		return joinDt;
	}
	public void setJoinDt(String joinDt) {
		this.joinDt = joinDt;
	}
	public String getRetireDt() {
		return retireDt;
	}
	public void setRetireDt(String retireDt) {
		this.retireDt = retireDt;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getUpDt() {
		return upDt;
	}
	public void setUpDt(String upDt) {
		this.upDt = upDt;
	}
//	notice dto
	private int no;
	private String title;
	private String content;
	private String writer;
	private int cnt;
	private String nRegDt;
	private String updt;
	private String delyn;
	
	private String reply;
	private int seq;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getnRegDt() {
		return nRegDt;
	}
	public void setnRegDt(String nRegDt) {
		this.nRegDt = nRegDt;
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
	
//	자격증 정보 DTO
	private String licnm = null;			// 자격증명
	private String issue = null;			// 발급처
	private String issuedt = null;			// 발급일
	private String licpic = null;			// 자격증 스캔
	private int lic_seq;
	
//	경력사항 DTO
	private String prjtnm = null;			// 프로젝트 명
	private String prjtskill = null;		// 소요 기술
	private String startdt = null;			// 시작일
	private String enddt = null;			// 종료일
	private String ordernm = null;			// 발주처
	private String rolecd = null;			// 역할 코드
	private int car_seq;
//	학력사항 DTO
	private String scd = null;				// 학력 코드
	private String scname = null;			// 학교명
	private String subjectnm = null;		// 학과명
	private String spic = null;				// 졸업증명 스캔 파일
	private String entrancedt = null;		// 입학일
	private String graduatedt = null;		// 졸업일
	private String graduateyn = null;		// 졸업여부
	private int aca_seq;
	
	public int getLic_seq() {
		return lic_seq;
	}
	public void setLic_seq(int lic_seq) {
		this.lic_seq = lic_seq;
	}
	public int getCar_seq() {
		return car_seq;
	}
	public void setCar_seq(int car_seq) {
		this.car_seq = car_seq;
	}
	public int getAca_seq() {
		return aca_seq;
	}
	public void setAca_seq(int aca_seq) {
		this.aca_seq = aca_seq;
	}
	public String getLicnm() {
		return licnm;
	}
	public void setLicnm(String licnm) {
		this.licnm = licnm;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getIssuedt() {
		return issuedt;
	}
	public void setIssuedt(String issuedt) {
		this.issuedt = issuedt;
	}
	public String getLicpic() {
		return licpic;
	}
	public void setLicpic(String licpic) {
		this.licpic = licpic;
	}
	public String getPrjtnm() {
		return prjtnm;
	}
	public void setPrjtnm(String prjtnm) {
		this.prjtnm = prjtnm;
	}
	public String getPrjtskill() {
		return prjtskill;
	}
	public void setPrjtskill(String prjtskill) {
		this.prjtskill = prjtskill;
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
	public String getRolecd() {
		return rolecd;
	}
	public void setRolecd(String rolecd) {
		this.rolecd = rolecd;
	}
	public String getScd() {
		return scd;
	}
	public void setScd(String scd) {
		this.scd = scd;
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public String getSubjectnm() {
		return subjectnm;
	}
	public void setSubjectnm(String subjectnm) {
		this.subjectnm = subjectnm;
	}
	public String getSpic() {
		return spic;
	}
	public void setSpic(String spic) {
		this.spic = spic;
	}
	public String getEntrancedt() {
		return entrancedt;
	}
	public void setEntrancedt(String entrancedt) {
		this.entrancedt = entrancedt;
	}
	public String getGraduatedt() {
		return graduatedt;
	}
	public void setGraduatedt(String graduatedt) {
		this.graduatedt = graduatedt;
	}
	public String getGraduateyn() {
		return graduateyn;
	}
	public void setGraduateyn(String graduateyn) {
		this.graduateyn = graduateyn;
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

	

