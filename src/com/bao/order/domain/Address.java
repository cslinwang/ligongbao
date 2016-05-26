package com.bao.order.domain;

public class Address {
 
	private String aid;
	private String uid;
    private String province;
    private String city;
    private String county;
    private String detaileaddress;
    private String postalcode;
    private String mobilennumber;
    private String addressee;
    
	public Address() {
		super();
	}
	public Address(String aid, String uid, String province, String city,
			String county, String detaileaddress, String postalcode,
			String mobilennumber, String addressee) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.province = province;
		this.city = city;
		this.county = county;
		this.detaileaddress = detaileaddress;
		this.postalcode = postalcode;
		this.mobilennumber = mobilennumber;
		this.addressee = addressee;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDetaileaddress() {
		return detaileaddress;
	}
	public void setDetaileaddress(String detaileaddress) {
		this.detaileaddress = detaileaddress;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getMobilennumber() {
		return mobilennumber;
	}
	public void setMobilennumber(String mobilennumber) {
		this.mobilennumber = mobilennumber;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
    
    
}
