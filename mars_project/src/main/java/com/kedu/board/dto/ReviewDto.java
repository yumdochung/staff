package com.kedu.board.dto;

public class ReviewDto {

	private String reivewno;
	private String reivewcontent;
	private String reivewlevel;
	private String reivewimg;
	private String hno;
	public String getReivewno() {
		return reivewno;
	}
	public void setReivewno(String reivewno) {
		this.reivewno = reivewno;
	}
	public String getReivewcontent() {
		return reivewcontent;
	}
	public void setReivewcontent(String reivewcontent) {
		this.reivewcontent = reivewcontent;
	}
	public String getReivewlevel() {
		return reivewlevel;
	}
	public void setReivewlevel(String reivewlevel) {
		this.reivewlevel = reivewlevel;
	}
	public String getReivewimg() {
		return reivewimg;
	}
	public void setReivewimg(String reivewimg) {
		this.reivewimg = reivewimg;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	@Override
	public String toString() {
		return "ReviewDto [reivewno=" + reivewno + ", reivewcontent=" + reivewcontent + ", reivewlevel=" + reivewlevel
				+ ", reivewimg=" + reivewimg + ", hno=" + hno + "]";
	}
	
	
	
}
