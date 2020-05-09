package com.ims.beans;

import java.util.List;

public class ItemMaster {

	private List<Item> item ;
	private Response response;
	
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	
	
}
