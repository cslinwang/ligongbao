package com.bao.sign.service;

import com.bao.sign.dao.SignDao;

public class SignService {
	SignDao sd=new SignDao();
	//�ж�ǩ��
	public String selectBySign(String uid) {
		return sd.selectBySign(uid);
	}
	//ǩ��
	public boolean sign(String date,String uid){
		if(sd.selectBySign(uid)==null){
			sd.addSigner(uid);
		}
		int num=sd.sign(date, uid);
		if(num!=0){
			return true;
		}else{
			return false;
		}
	}
}
