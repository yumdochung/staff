package com.kedu.board.dto;

public class MypageDto {

	private int mjjim;
	private String mid;
	private String hno;
	
	public int getMjjim() {
		return mjjim;
	}
	public void setMjjim(int mjjim) {
		this.mjjim = mjjim;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	@Override
	public String toString() {
		return "MypageDto [mjjim=" + mjjim + ", mid=" + mid + ", hno=" + hno + "]";
	}
	
	
}
