package com.liuhao.pojo;

public class Condition {

	private Integer currentPage;
	private String mohu1;
	private String mohu2;
	private String mohu3;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String getMohu1() {
		return mohu1;
	}
	public void setMohu1(String mohu1) {
		this.mohu1 = mohu1;
	}
	public String getMohu2() {
		return mohu2;
	}
	public void setMohu2(String mohu2) {
		this.mohu2 = mohu2;
	}
	public String getMohu3() {
		return mohu3;
	}
	public void setMohu3(String mohu3) {
		this.mohu3 = mohu3;
	}
	public Condition() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Condition [currentPage=" + currentPage + ", mohu1=" + mohu1 + ", mohu2=" + mohu2 + ", mohu3=" + mohu3
				+ "]";
	}
	public Condition(Integer currentPage, String mohu1, String mohu2, String mohu3) {
		super();
		this.currentPage = currentPage;
		this.mohu1 = mohu1;
		this.mohu2 = mohu2;
		this.mohu3 = mohu3;
	}
	
}
