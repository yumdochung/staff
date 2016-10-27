package com.kedu.board.dto;

public class BoardDto {

	private String bno;
	private String btitle;
	private String bcontent;
	private String bwritedt;
	private int bcount;
	private int bboard;
	private String bupdatedt;
	private String bwriter;
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwritedt() {
		return bwritedt;
	}
	public void setBwritedt(String bwritedt) {
		this.bwritedt = bwritedt;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	public int getBboard() {
		return bboard;
	}
	public void setBboard(int bboard) {
		this.bboard = bboard;
	}
	public String getBupdatedt() {
		return bupdatedt;
	}
	public void setBupdatedt(String bupdatedt) {
		this.bupdatedt = bupdatedt;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwritedt=" + bwritedt
				+ ", bcount=" + bcount + ", bboard=" + bboard + ", bupdatedt=" + bupdatedt + ", bwriter=" + bwriter
				+ "]";
	}
	
	
}
