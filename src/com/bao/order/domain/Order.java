package com.bao.order.domain;
/*
 *订单模块autour张兴凯 
 * 
 * */

public class Order {

	private String oid;  //订单id
	private String uid;  //用户id
	private String nid;  //电脑id
	private String aid;  //地址id
	private String stime;
	private String image;
	private String nname;
    private int counts;
    private float nrprice;
    private int statu;
    
    
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public float getNrprice() {
		return nrprice;
	}
	public void setNrprice(float nrprice) {
		this.nrprice = nrprice;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}

	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	
	
	
	
	
	
	
	
}
