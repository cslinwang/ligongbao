package com.bao.computer.domain;
/*
 * computer ʵ����
 * �������ݿ������computer����
 * �ι�ȫ
 * */
public class Computer {
/*
 * �������ݿ����������
 * */
	private String nid;
	private String nname;
	private float nprice; 
	private float ndiscount;
	private float nrprice;
	private String nimage;
	private String ncompany;
	
	
	
	
   public Computer(){}
/*
 * �������Ӧ��set��get����
 */
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public float getNprice() {
		return nprice;
	}
	public void setNprice(float nprice) {
		this.nprice = nprice;
	}
	public float getNdiscount() {
		return ndiscount;
	}
	public void setNdiscount(float ndiscount) {
		this.ndiscount = ndiscount;
	}
	public float getNrprice() {
		return nrprice;
	}
	public void setNrprice(float nrprice) {
		this.nrprice = nrprice;
	}
	public String getNimage() {
		return nimage;
	}
	public void setNimage(String nimage) {
		this.nimage = nimage;
	}
	public String getNcompany() {
		return ncompany;
	}
	public void setNcompany(String ncompany) {
		this.ncompany = ncompany;
	}
	
	
	
}
