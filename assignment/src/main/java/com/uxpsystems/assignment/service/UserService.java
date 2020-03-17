package com.uxpsystems.assignment.service;

import java.sql.SQLException;

import com.uxpsystems.assignment.model.Login;
import com.uxpsystems.assignment.model.User;

public interface UserService {
	String register(User user) throws SQLException;

	boolean findAllEmployees(String uname, String pwd) throws SQLException;
}
