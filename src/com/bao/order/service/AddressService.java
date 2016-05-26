package com.bao.order.service;

import java.util.List;

import com.bao.order.dao.AddressDao;
import com.bao.order.domain.Address;

public class AddressService {

	AddressDao addressDao = new AddressDao();

	// ���û���ѯ���е�ַ
	public List<Address> findByUid(String uid) {
		return addressDao.findByUid(uid);
	}

	// ���ӵ�ַ��¼
	public boolean addAddress(Address address) {

		int num = addressDao.addAddress(address);
		if(num!=0){
			return true;
		}else{
			return false;
		}
	}

	// ɾ����ַ��¼
	public boolean dropAddress(String aid) {
		return addressDao.dropAddress(aid);
	}

	// ��aid��ѯ��ַ��Ϣ
	public Address findByAid(String aid) {
		return addressDao.findByAid(aid);
	}
}
