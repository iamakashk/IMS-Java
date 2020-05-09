package com.ims.dao.login;

import com.ims.beans.UserDetails;

public interface LoginDAO {

	UserDetails validateUserDAO(String logId, String userId, String password);
}
