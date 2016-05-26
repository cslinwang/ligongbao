package com.bao.shopcart.service;

import java.util.List;

import com.bao.shopcart.dao.ShopCartDao;
import com.bao.shopcart.domain.ShopCart;

public class ShopCartService {
     ShopCartDao shopcartDao = new ShopCartDao();
     //修改商品数量
     public boolean changeCount(int scount, String sid){
    	 return shopcartDao.changeCount(scount, sid);
     }
     //往购物车里面添加商品
     public boolean addShopCart(ShopCart shopcart){
    	 
    	 int num=shopcartDao.addShopCart(shopcart);
    	 if(num!=0){
    		 System.out.println("添加到购物车成功");
    		 return true;
    	 }else{
    		 System.out.println("添加到购物车失败");
    		 return false;
    	 }
     }
     
     //查询购物车里面的所有商品信息
     public List<ShopCart> findByUid(String uid){
    	 
    	 return shopcartDao.findByUid(uid);
     }
     
     //通过sid删除购物车内的商品信息
     public boolean deleteBySid(String sid){
    	 
    	 return shopcartDao.deleteBySid(sid);
     }
}
