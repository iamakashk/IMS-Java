package com.ims.beans;

import com.ims.beans.login.Users;

public class UserDetails{

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Response getResponseBean() {
		return responseBean;
	}
	public void setResponseBean(Response responseBean) {
		this.responseBean = responseBean;
	}
	private Users user;
	private Response responseBean;
	
}
