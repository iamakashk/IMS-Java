package com.ims.controller;

public class RestMappingProvider {

	public static final String API_VERSION = "/inventory/api/v1";
	
	public static final String INFO = "/info";
	public static final String SENDNOTIFICATION = "/status";
	public static final String SAMPLE = "/sample";
	
	//LOGIN CONTROLLER RELATED MAPPING
	public static final String LOGIN_VALIDATE = "/login/validate/{loginId}/{password}";
	
	//ITEM MASTER MAPPING
	public static final String ITEMS_GET_ALL = "/items";
	public static final String ITEMS_GET_SINGLE = "/items/{itemCode}";
	public static final String ITEMS_UPDATE_SINGLE_ITEM = "/items";
	public static final String ITEMS_DELETE_SINGLE="/items/{itemCode}";
	public static final String ITEMS_CREATE_SINGLE = "/item";
	public static final String ITEMS_SINGLE_ITEM_PAGINATION = "/items/pagination";
	
	
	//CUSTOMER MASTER MAPPINGS
	public static final String CUSTOMER_GET_ALL = "/customers";
	public static final String CUSTOMER_ADD = "/customers/{actionType}";
	public static final String CUSTOMER_UPDATE = "/customer/update";
	public static final String CUSTOMER_DELETE = "/customer/delete";
	public static final String CUSTOMER_GET_SINGLE = "/customer/{custCode}";
	public static final String CUSTOMER_PAGINATION = "/items/pagination";
	
	//city and state
	public static final String USER_STATES = "/states";
	public static final String USER_CITY_USING_STATE = "/cities/{stateId}";
	
	//Arealocation and source
	public static final String AREA_LOCATION = "/arealocation";
	public static final String CUSTOMER_SOURCE = "/source/{actionType}";
	
	//enquiry master
	public static final String ENQUIRY = "/enquiry/{actionType}";
	
	// SYSTEM LOGIN
	public static final String LOGIN_CONTROLLER_CHECK = "login/check";
}
