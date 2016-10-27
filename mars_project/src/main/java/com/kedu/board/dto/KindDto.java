package com.kedu.board.dto;

public class KindDto {

	private String kno;
	private String hno;
	public String getKno() {
		return kno;
	}
	public void setKno(String kno) {
		this.kno = kno;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	@Override
	public String toString() {
		return "KindDto [kno=" + kno + ", hno=" + hno + "]";
	}
	
	
}
