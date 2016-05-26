package com.bao.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bao.db.JDBC;
import com.bao.order.domain.Address;

/**
 * 
 * @author DBQ
 * 
 */
public class AddressDao {

	Connection con = JDBC.getConnection();

	// 按用户查询地址地址记录
	public List<Address> findByUid(String uid) {
		List<Address> addressList = new ArrayList<Address>();
		try {
			String sql = "select * from note_address where uid like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, uid);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Address address = new Address();
				address.setAid(res.getString("aid"));
				address.setProvince(res.getString("province"));
				address.setCity(res.getString("city"));
				address.setCounty(res.getString("county"));
				address.setDetaileaddress(res.getString("detaileaddress"));
				address.setPostalcode(res.getString("postalcode"));
				address.setMobilennumber(res.getString("mobilenumber"));
				address.setAddressee(res.getString("addressee"));
				address.setUid(res.getString("uid"));

				addressList.add(address);
			}
		} catch (SQLException se) {
			System.err.println("锟斤拷询锟斤拷锟叫碉拷址锟斤拷锟斤拷");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return addressList;
	}

	// 删除地址记录
	public boolean dropAddress(String aid) {
		boolean b = false;
		try {
			String sql = "delete from note_address where aid like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, aid);
			ResultSet res = pst.executeQuery();
			if (res.next()) {
				b = false;
			} else {
				b = true;
			}
		} catch (SQLException se) {
			System.err.println("删除地址出错");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return b;
	}

	// 增加地址记录
	public int addAddress(Address address) {
		int num=0;
		try {
			String sq = "insert into note_address(aid,province,city,county,detaileaddress,postalcode,mobilenumber,addressee,uid) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sq);
			pst.setString(1, address.getAid());
			pst.setString(2, address.getProvince());
			pst.setString(3, address.getCity());
			pst.setString(4, address.getCounty());
			pst.setString(5, address.getDetaileaddress());
			pst.setString(6, address.getPostalcode());
			pst.setString(7, address.getMobilennumber());
			pst.setString(8, address.getMobilennumber());
			pst.setString(9, address.getUid());
			num=pst.executeUpdate();
			if (num!=0) {
				System.out.println("增加地址成功");
			} else {
				System.out.println("增加地址失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	// 按aid查询地址记录
	public Address findByAid(String aid) {

		Address address = new Address();

		try {
			String sql = "select * from note_address where aid like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, aid);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				address.setAid(rs.getString("aid"));
				address.setProvince(rs.getString("province"));
				address.setCity(rs.getString("city"));
				address.setCounty(rs.getString("county"));
				address.setDetaileaddress(rs.getString("detaileaddress"));
				address.setPostalcode(rs.getString("postalcode"));
				address.setMobilennumber(rs.getString("mobilenumber"));
				address.setAddressee(rs.getString("addressee"));
				address.setUid(rs.getString("uid"));
			} else {
				System.out.println("用户不存在");
			}
		} catch (SQLException se) {
			System.out.println("按aid查询地址记录时出错");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return address;
	}
}
