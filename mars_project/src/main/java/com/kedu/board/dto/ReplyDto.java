package com.kedu.board.dto;

public class ReplyDto {

	private String rno;
	private String rcontent;
	private String rwritedt;
	private String mid;
	private String bno;
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRwritedt() {
		return rwritedt;
	}
	public void setRwritedt(String rwritedt) {
		this.rwritedt = rwritedt;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "ReplyDto [rno=" + rno + ", rcontent=" + rcontent + ", rwritedt=" + rwritedt + ", mid=" + mid + ", bno="
				+ bno + "]";
	}
	
	
}
