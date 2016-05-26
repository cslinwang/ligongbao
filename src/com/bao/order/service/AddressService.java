package com.bao.order.service;

import java.util.List;

import com.bao.order.dao.AddressDao;
import com.bao.order.domain.Address;

public class AddressService {

	AddressDao addressDao = new AddressDao();

	// 按用户查询所有地址
	public List<Address> findByUid(String uid) {
		return addressDao.findByUid(uid);
	}

	// 增加地址记录
	public boolean addAddress(Address address) {

		int num = addressDao.addAddress(address);
		if(num!=0){
			return true;
		}else{
			return false;
		}
	}

	// 删除地址记录
	public boolean dropAddress(String aid) {
		return addressDao.dropAddress(aid);
	}

	// 按aid查询地址信息
	public Address findByAid(String aid) {
		return addressDao.findByAid(aid);
	}
}
