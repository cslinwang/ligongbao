package com.bao.shopcart.service;

import java.util.List;

import com.bao.shopcart.dao.ShopCartDao;
import com.bao.shopcart.domain.ShopCart;

public class ShopCartService {
     ShopCartDao shopcartDao = new ShopCartDao();
     //�޸���Ʒ����
     public boolean changeCount(int scount, String sid){
    	 return shopcartDao.changeCount(scount, sid);
     }
     //�����ﳵ���������Ʒ
     public boolean addShopCart(ShopCart shopcart){
    	 
    	 int num=shopcartDao.addShopCart(shopcart);
    	 if(num!=0){
    		 System.out.println("��ӵ����ﳵ�ɹ�");
    		 return true;
    	 }else{
    		 System.out.println("��ӵ����ﳵʧ��");
    		 return false;
    	 }
     }
     
     //��ѯ���ﳵ�����������Ʒ��Ϣ
     public List<ShopCart> findByUid(String uid){
    	 
    	 return shopcartDao.findByUid(uid);
     }
     
     //ͨ��sidɾ�����ﳵ�ڵ���Ʒ��Ϣ
     public boolean deleteBySid(String sid){
    	 
    	 return shopcartDao.deleteBySid(sid);
     }
}
