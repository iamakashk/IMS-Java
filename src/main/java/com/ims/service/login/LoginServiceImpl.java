package com.ims.service.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.UserDetails;
import com.ims.dao.login.LoginDAO;


@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOG = LogManager.getFormatterLogger();
	@Autowired
	public LoginDAO loginDAO;


	@Override
	public UserDetails validateUser(String logId, String userId, String password) {
		UserDetails userDetails  = loginDAO.validateUserDAO(logId, userId, password);
		return userDetails;
	}

}
