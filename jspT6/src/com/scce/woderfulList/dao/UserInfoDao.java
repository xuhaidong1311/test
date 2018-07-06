package com.scce.woderfulList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.scce.woderfulList.utilts.utilts;

public class UserInfoDao {
	
	//账号密码查询代码
	public UserInfo queryUserInfo(String account,String password){
		UserInfo user1 =null;
		//获取数据库的链接
		Connection conn = utilts.getConnection();
		String sql = "select * form t_userinfo where account=? or password=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, account);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				user1 = new UserInfo();
				user1.setAccount(rs.getString("account"));
				user1.setPassword(rs.getString("password"));
				user1.setType(rs.getInt("type"));
				user1.setOnline(rs.getInt("on_line"));
				user1.setSex(rs.getString("sex"));
				user1.setNickname(rs.getString("Nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询数据库信息错误");
		}
		return user1;
	}
	
	public void updateUserinfo(int status,String account){
		
	}
}
