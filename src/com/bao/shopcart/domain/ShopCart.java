package com.bao.shopcart.domain;


/**
 * ���ﳵʵ����
 * 
 * @author ������
 * 
 */
public class ShopCart {

	private String sid;// ���ﳵ��id
	private String uid;// �û���id
	private String nid;// Ҫ����ĵ��Ե�id
	private String stime;// ��ӹ��ﳵ��ʱ��
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
