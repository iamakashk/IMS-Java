package com.ims.service.login;

import com.ims.beans.UserDetails;

public interface LoginService {

	UserDetails validateUser(String logId, String userId, String password);

}
