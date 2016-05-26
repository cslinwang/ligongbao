package com.bao.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Md5摘要生成工具
 * @author WangLin
 *
 */
public class Md5Utils {

	//传入一个字符串然后返回一个散列字符串
	public static String MD5(String plainText){
		
     StringBuffer buf = new StringBuffer("");
   	 try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte[] b = md.digest();
			int i;
			for(int offset = 0;offset<b.length;offset++){
				 i = b[offset];
				 if(i<0){
					 i+=256;
				 }
				 if(i<16){
					 buf.append("0");
				 }
				 buf.append(Integer.toHexString(i));
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
   	 return buf.toString();
    }
}
