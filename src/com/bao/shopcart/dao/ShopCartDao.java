package com.bao.shopcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bao.db.JDBC;
import com.bao.shopcart.domain.ShopCart;

public class ShopCartDao {
	Connection con = JDBC.getConnection();

	// 更改数量
	public boolean changeCount(int scount, String sid) {
		int num = 0;
		boolean b = true;
		
		try {
			String sql = "update note_shopping set scount=? where sid = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, scount);
			pst.setString(2, sid);
			num = pst.executeUpdate();
			if (num != 0) {
				System.out.println("yes");
				b = true;
			} else {
				System.out.println("noooo");
				b = false;
			}
		} catch (SQLException se) {
			System.out.println("修改密码出错");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return b;
	}

	// 添加购物车
	public int addShopCart(ShopCart shopcart) {
		int num = 0;
		try {
			String sql = "insert into note_shopping VALUES(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, shopcart.getSid());
			pst.setString(2, shopcart.getUid());
			pst.setString(3, shopcart.getNid());
			pst.setString(4, shopcart.getStime());
			pst.setInt(5, 2);
			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	// 查询购物车
	public List<ShopCart> findByUid(String uid) {
		ResultSet res = null;
		List<String> stringList = new ArrayList<String>();
		List<ShopCart> shopcartList = new ArrayList<ShopCart>();
		int num = 0;
		try {
			String sql = "select * from note_shopping where uid = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, uid);
			res = pst.executeQuery();
			while (res.next()) {
				ShopCart shopcart = new ShopCart();
				String nid = res.getString("nid");
				shopcart.setNid(nid);
				shopcart.setSid(res.getString("sid"));
				shopcart.setUid(uid);
				shopcart.setStime(res.getString("stime"));
				shopcart.setScount(res.getInt("scount"));
				stringList.add(nid);
				shopcartList.add(shopcart);
			}

			for (int i = 0; i < stringList.size(); i++) {
				String sq = "select * from note_computer where nid = ?";
				PreparedStatement ps = con.prepareStatement(sq);
				ps.setString(1, stringList.get(i));
				ResultSet re = ps.executeQuery();
				while (re.next()) {
					shopcartList.get(i).setNimage(re.getString("nimage"));
					shopcartList.get(i).setNname(re.getString("nname"));
					shopcartList.get(i).setNrprice(re.getString("nrprice"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return shopcartList;

	}

	// 删除购物车
	public boolean deleteBySid(String sid) {
		int num = 0;
		ResultSet res = null;
		boolean result = false;
		try {
			String sql = "delete from note_shopping where sid like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, sid);
			num = pst.executeUpdate();
			if (num == 0) {
				result = false;
			} else {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
	public static void main(String[] args) {
		boolean falg=new ShopCartDao().changeCount(1, "0A4EC6FCB12049E69C4E0113F80A3FE5");
		if(falg){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
}
