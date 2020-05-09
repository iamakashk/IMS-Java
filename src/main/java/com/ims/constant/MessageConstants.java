package com.ims.constant;

public class MessageConstants{
	public static final String LOGGER_APP_BAR = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	public static final String LOGGER_APP_START_BAR = "XXXXXXXXXXXXXXXXXXXXXXX APPLICATION STARTING XXXXXXXXXXXXXXXXXXXXXXXX";
	public static final String LOGGER_APP_START_PASS_BAR = "XXXXXXXXXXXXXXXXXXX APPLICATION STARTED SUCCESSFULLY XXXXXXXXXXXXXXXX";
	public static final String LOGGER_APP_START_FAIL_BAR = "XXXXXXXXXXXXXXXXXXXXX APPLICATION STOPPED ABRUPTLY XXXXXXXXXXXXXXXXXX";

	public static final String NEW_REQUEST = "[<<] [<<] [<<] [<<] [<<] **NEW REQUEST* [<<] [<<] [<<] [<<] [<<]";
	public static final String SENDING_RESPONSE = "[>>] [>>] [>>] [>>] [>>] **SENDING RESPONSE TO CLIENT** [>>] [>>] [>>] [>>] [>>] \n";
	public static final String LOGGER_START_MTHD = " Start Processing ";
	public static final String LOGGER_END_MTHD = " End Processing ";
	public static final String LOGGER_MTHD = " method ";
	public static final String EXEC_TIME = " Execution time:  ";
	public static final String LOGGER_EXCEPTION_MESSAGE = " << Below is the full stack trace for error occured >> ";
	public static final String LOGGER_ERROR_MESSAGE = "Error Occurred during initializing application";

	/**
	 * ==================================================================================
	 * DEFAULT MESSAGES
	 * ==================================================================================
	 */

	public static final String SERVER_UP_RUNNING = "DEMO SERVICE UP & RUNNING";
	public static final String OTP_SEND_RESPONSE_MSG = "OTP IS SEND TO YOUR REGISTER EMAIL & MOBILE NO.";
	public static final String RESET_PASSWORD_MSG = "Reset Your ETP License Server Password";
	public static final String SETUP_INITIATE_MSG = "Setup Initiated";
	public static final String PASSWORD_CHANGE_MSG = "Password changed successfully";
	public static final String USER_REGISTER_SUCESS_MSG = "User registered successfully";
	public static final String USER_REGISTER_FAIL_MSG = "User registration failed";
	public static final String USER_UPDATE_SUCESS_MSG = "User update successfully";
	public static final String USER_UPDATE_FAIL_MSG = "User update failed";
	public static final String USER_AVAILABLE_MSG = "User information is available";
	public static final String USER_NOT_AVAILABLE_MSG = "User information is not available";
	public static final String USER_NOT_ACTIVE_MSG = "User is not active";
	public static final String USER_VALIDATION_SUCESS_MSG = "USER VALIDATION SUCESS";
	public static final String USER_VALIDATION_FAIL_MSG = "USER VALIDATION FAILED";

	public static final String CLIENT_REGISTER_SUCESS_MSG = "Client registered successfully";
	public static final String CLIENT_REGISTER_FAIL_MSG = "Client registered fail to save";
	public static final String CLIENT_UPDATE_SUCESS_MSG = "Client update successfully";
	public static final String CLIENT_UPDATE_FAIL_MSG = "Client update failed";

	public static final String CLIENT_AGREEMENT_SUCESS_MSG = "Client agreement successfully";
	public static final String CLIENT_AGREEMENT_FAIL_MSG = "Client agreement failed to save";
	public static final String CLIENT_AGREEMENT_UPDATE_SUCESS_MSG = "Client agreement update successfully";
	public static final String CLIENT_AGREEMENT_UPDATE_FAIL_MSG = "Client agreement update failed";
	public static final String CLIENT_AGREEMENT_UPDATE_FAIL_ACTIVE_SUB = "Agreement can not delete as there are some subscription which are active.";

	public static final String CLIENT_SUBSCRIPTION_SUCESS_MSG = "Client subscription added successfully";
	public static final String CLIENT_SUBSCRIPTION_FAIL_MSG = "Client subscription failed to save.";
	public static final String CLIENT_SUBSCRIPTION_UPDATE_SUCESS_MSG = "Client subscription update successfully";
	public static final String CLIENT_SUBSCRIPTION_UPDATE_FAIL_MSG = "Client subscription update failed";

	public static final String EMAIL_SEND_SUCCESS_MSG = "Email send successfully to email address:{0}";
	public static final String EMAIL_SEND_FAILURE_MSG = "Email not send.Please check server log";
	public static final String PASSWORD_VALIDATION_SUCESS_MSG = "PASSWORD VALIDATION SUCCESS";
	public static final String PASSWORD_VALIDATION_FAIL_MSG = "PASSWORD VALIDATION FAIL";
	public static final String MOBILE_NO_NOT_REGISTER_MSG = "Mobile no. is not registered.Please register mobile no. and then try";
	public static final String FILE_UPLOAD_SUCESS_MSG = "File uploaded successfully";
	public static final String FILE_UPLOAD_FAIL_MSG = "File upload failed";
	public static final String REGISTER_USER = "resister user";

	public static final String AGREEMENT_FILE_DELETED = "Agreement file deleted.";
	public static final String AGREEMENT_FILE_NOT_DELETED = "Failure agreement file not deleted.";
	public static final String AGREEMENT_NUMBER_NULL = "AGREEMENT NUMBER IS NULL OR EMPTY.CAN NOT ADD SUBSCRIPTION";
	public static final String LICENSE_EXPIRE = "LICENSE EXPIRE";

	public static final String TABLE_STRUCTURE_SAVE_SUCESS_MSG = "Table Structure save successfully";
	public static final String TABLE_STRUCTURE_SAVE_FAIL_MSG = "Table Structure save failure";
	
	public static final String GETTING_SESSION_DB_MSG = "getting session from database";
	public static final String SESSION_CREATED_MSG = "Hibernate Session created.";
	public static final String SESSION_NOT_CREATED_MSG = "Hibernate Session not created.Please check database property";
	
	public static final String REDIS_CONFIGURATION_START_MSG = "REDIS CONFIGURATION START";
	public static final String REDIS_CONFIGURATION_END_MSG = "REDIS CONFIGURATION END";
	public static final String REDIS_SERVER_UP_OR_DOWN_MSG="Checking Redis server is up & Running on port no: ";
	public static final String REDIS_SERVER_UP_MSG="REDIS SERVER IS UP & RUNNING ON PORT NO: ";
	public static final String REDIS_SERVER_DOWN_MSG="REDIS SERVER IS DOWN";
	
	public static final String PROPERTY_FILE_READING_START_MSG = "READING PROPERTY FILE";
	public static final String PROPERTY_FILE_READING_SUCESS_MSG = "READING PROPERTY FILE COMPLETE";
	public static final String PROPERTY_FILE_READING_FAIL_MSG = "ERROR OCCURED WHILE READING PROPERTY FILE";
	
	public static final String QUITING_SERVICE_MSG = "QUITING SERVICE";
	public static final String LOGID_NOT_GENERATE_MSG = "LOG ID NOT GENERATE";
	public static final String REQUEST_BODY = "Request Body: " ;
	public static final String GENERATE_LOG_ID_MSG = "GENERATING LOG ID" ;
	public static final String GENERATE_LOG_ID_SUCESS_MSG = "LOG ID GENERATE: "  ;
	
	public static final String REQUEST_BODY_TYPE_XML = "REQUEST BODY TYPE IS XML"  ;
	public static final String REQUEST_BODY_TYPE_JSON = "REQUEST BODY TYPE IS JSON"  ;
	public static final String REQUEST_KEY_NOT_PRESENT = "REQUEST KEY NOT PRESENT"  ;
	public static final String REQUEST_KEY_VALIDATION_START_MSG = "REQUEST KEY VALIDATION START"  ;
	public static final String REQUEST_KEY_VALIDATION_COMPLETED_MSG = "REQUEST KEY VALIDATION COMPLETED"  ;
	
	public static final String TRUSTED_SOURCE_VALIDATION_START_MSG = "TRUSTED_SOURCE VALIDATION START"  ;
	public static final String TRUSTED_SOURCE_VALIDATION_COMPLETED_MSG = "TRUSTED_SOURCE VALIDATION COMPLETED"  ;
	
	public static final String SALT_KEY_NOT_PRESENT_CACHE_MSG = "SALT KEY NOT PRESENT IN CACHE"  ;
	
	//LOGIN RELATED MESSAGES
	public static final String LOGIN_SUCCESS = " YOU HAVE BEEN LOGGED IN SUCCESSFULLY";
	public static final String LOGIN_ERROR = " INVALID USERID AND PASSWORD COMBINATION. PLEASE TRY AGAIN.";
	
	//ITEM MASTER RELATED MESSAGES
	public static final String ITEMS_ITEM_ADD_SUCCESS = "ITEM SUCCESSFULLY ADDED.";
	public static final String ITEMS_ITEM_ADD_ERROR = "ERROR WHILE ADDING ITEM IN THE DATABASE";
	public static final String ITEMS_ITEM_DELETE_SUCCESS = "ITEM DELETED SUCCESSFULLY.";
	public static final String ITEMS_ITEM_DELETE_ERROR = "ERROR WHILE DELETING ITEM FROM DATABASE";
	public static final String ITEMS_ITEM_UPDATE_SUCCESS = "ITEM UDPATED SUCCESSFULLY";
	public static final String ITEMS_ITEM_UPDATE_ERROR = "ERROR WHILE UPDATING ITEM.PLEASE TRY AGAIN AFTER SOME TIME OR CONTACT YOUR IT SUPPORT.";
	public static final String ITEMS_ITEMS_GET_ERROR = "ERROR WHILE FETCHING ITEMS DETAIL FROM DATABASE. PLEASE TRY AFTER SOME TIME OR CONTACT YOUR IT SUPPORT.";
	public static final String ITEMS_NO_ITEM_FOUND = "NO SUCH ITEM EXIST. PLEASE CHECK PROVIDED ITEM CODE.";
	public static final String ITEMS_GET_ALL_SUCCESS = "SUCCESSFULLY FETCHED ALL ITEMS FROM DATABASE";
	public static final String ITEMS_GET_SINGLE_SUCCESS = "SUCCESSFULLY FETCHED ITEM FROM DATABASE";
	
	
	// SYSTEM LOGIN
	public static final String LOGIN_CONTROLLER_CHECK = "login/check";
	
	
	
}

