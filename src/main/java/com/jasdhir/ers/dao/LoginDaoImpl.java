package com.jasdhir.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jasdhir.ers.model.ERSUser;
import com.jasdhir.ers.utils.ConnectionUtils;

public class LoginDaoImpl implements LoginDao{

	@Override
	public ERSUser login(String userName, String pwd) {
		// TODO Auto-generated method stub
		ERSUser ersUser=null;
		Connection dbConn;
		try {
			dbConn=ConnectionUtils.getInstance().getConnection();
			String fetchUser="select * from ersuser where username=? and password=?";
			PreparedStatement preparedStatement = dbConn.prepareStatement(fetchUser);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, pwd);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ersUser=new ERSUser();
				ersUser.setId(resultSet.getInt(1));
				ersUser.setUserRole(resultSet.getString(2));
				ersUser.setEmail(resultSet.getString(3));
				ersUser.setFirstName(resultSet.getString(4));
				ersUser.setLastName(resultSet.getString(5));
				ersUser.setUserName(resultSet.getString(6));
				ersUser.setPassword(resultSet.getString(7));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ersUser;
	}

}
