package com.bao.shopcart.domain;


/**
 * 购物车实体类
 * 
 * @author 张立国
 * 
 */
public class ShopCart {

	private String sid;// 购物车的id
	private String uid;// 用户的id
	private String nid;// 要购买的电脑的id
	private String stime;// 添加购物车的时间
	private String nimage;
	private String nname;
	private String nrprice;
	private int    scount;
   
	public String getNimage() {
		return nimage;
	}

	public void setNimage(String nimage) {
		this.nimage = nimage;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getNrprice() {
		return nrprice;
	}

	public void setNrprice(String nrprice) {
		this.nrprice = nrprice;
	}

	public int getScount() {
		return scount;
	}

	public void setScount(int scount) {
		this.scount = scount;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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
