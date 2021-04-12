package com.asm3.mobie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.asm3.mobie.connection.MyConnection;
import com.asm3.mobie.model.User;

public class UserDAO {
	static Connection connect = MyConnection.connect();
	
	//Hàm kiểm tra tài khoản mật khẩu
	public static boolean checkAccount(String account,String password) throws SQLException {
		Boolean flag = false;
		String sql = "SELECT * FROM Account A WHERE A.user_mail = '"+account+"' AND A.password = '"+password+"'";
		Statement stm = connect.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			if(!rs.getString("user_mail").equals("")) {
				flag = true;
			}
		}
		return flag;
	}
	
	
	public static User getUserByemail(String email) throws SQLException {
		User user = new User();
		String sql = "SELECT * FROM Account A WHERE A.user_mail = '" + email + "'";
		Statement stm = connect.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			user.setName(rs.getString("user_mail"));
			user.setAddress(rs.getString("user_address"));
		}
		return user;
	}
	
	public static void registerForAccount(String mail,String pass,String name,String address,String phone) throws SQLException {
		String sql = "INSERT INTO Account VALUES('"+mail+"','"+pass+"',1,'"+name+"','"+address+"','"+phone+"')";
		Statement stm = connect.createStatement();
		stm.executeUpdate(sql);
	}
}
