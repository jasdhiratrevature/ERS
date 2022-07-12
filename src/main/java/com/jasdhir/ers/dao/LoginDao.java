package com.jasdhir.ers.dao;

import com.jasdhir.ers.model.ERSUser;

public interface LoginDao {
ERSUser login(String userName,String pwd);
}
