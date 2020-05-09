/*package com.etp.galaxy.hubana.demo.common;*/

package com.ims.constant;

import java.io.File;

/*
 * ==============================================================================
 *	Copyright ETP International. All rights reserved.
 *	Licensed material property of ETP Group.  
 * ==============================================================================
 * ========================== Change History ====================================
 * ==============================================================================
 * ID   AuthorID  	DtChange   	ModID/IssueID  	 Method Name 					Description	
 * ----------------------------------------------------------------------------
 *                                
 * */
/**
 * <<-- Business Description of this class to be written here -->>
 * @author 
 * @since 
 * @version 1.0
 */
public class CommonConstants {
	
	
	
	public static final String SLASH="/";
	public static final String BACKSLASH="\\";
	public static final String WHITESPACE= " ";
	public static final String BLANK= "";
	public static final String COMMA= ",";
	public static final String COLON= ":";
	public static final String SEMI_COLON= ";";
	public static final String DOT= ".";
	public static final String DELIM_TILDE= "~";
	public static final String DELIM_HASH= "#";
	public static final String NEWLINE= "\n";
	public static final String HYPHEN= "-";
	public static final String UNDERSCORE= "_";
	public static final String PERCENTAGE= "%";
	public static final String DOUBLE_COLON="::";
	
	public static final String LOGGER_START_MTHD = " Start Processing ";
	public static final String LOGGER_END_MTHD = " End Processing ";
	public static final String LOGGER_MTHD = " method ";
	public static final String LOGGER_EXCEPTION_MESSAGE = " << Below is the full stack trace for error occured >> ";
	public static final String NEW_REQUEST = "[<<] [<<] [<<] [<<] [<<] **NEW REQUEST* [<<] [<<] [<<] [<<] [<<]";
	public static final String SENDING_RESPONSE = "[>>] [>>] [>>] [>>] [>>] **SENDING RESPONSE TO CLIENT** [>>] [>>] [>>] [>>] [>>] \n";
	public static final String EXEC_TIME = " Execution time : ";
	public static final String EXCEPTION_STRING_START = "############EXCEPTION START###########";
	public static final String EXCEPTION_STRING_END = "##########EXCEPTION END###########";
	public static final String INPUT_START = "##INPUT START##";
	public static final String INPUT_END = "##INPUT END##";
	public static final String REMOTE_HOST = "Remote host: ";
	public static final String strGalaxy = "________________________________________________________________________________________________________________________________"
			+ "\n   ____      ___     _       ___     __   __ __    __   __ _ _ "
			+ "\n/*/        /*/ \\*\\  |*|    /*/ \\*\\  \\*\\  /*/ \\*\\  /*/   \\ \\ \\ \\"
			+ "\n|*|   ___ |*|___|*| |*|   |*|___|*|  \\*\\/*/   \\*\\/*/     \\ \\ \\ \\ "
			+ "\n|*|   |*| |*|   |*| |*|   |*|   |*|  /*/\\*\\    |*|       ) ) ) )"
			+ "\n\\*\\---|*| |*|   |*| |*|__ |*|   |*| /*/  \\*\\   |*|      / / / /"
			+ "\n `------' '-'   '-' '----''-'   '-''-'    '-'  '-'     /_/_/_/"
			+ "\n____________________________________________________________________________________________________________________________";

	public static final String FILE_OPERATION_DOWNLOAD = "D";
	public static final String FILE_OPERATION_VIEW = "V";

	public static final int EXPIRED_AFTER_60_DAYS = 60;
	public static final int EXPIRED_AFTER_45_DAYS = 45;
	public static final int EXPIRED_AFTER_30_DAYS = 30;
	public static final int EXPIRED_AFTER_15_DAYS = 15;
	public static final int EXPIRED_AFTER_7_DAYS = 7;
	public static final int EXPIRED_TODAY = 0;

	public static final String MOBILE_NO = "Mobile No";
	public static final String DEFAULT_USER_IMAGE = "etp_User.jpg";
	public static final String LICENSE_KEY_SEPARATOR = "~";
	public static final String ADMIN_USER_NAME = "License Admin";
	public static final String DEFAULT_USER_PASSWORD = "t8ir3GYgTAbnxR1eveJosQ=="; // Etp@123456
	public static final int NORMAL_USER_TYPE = 1;
	public static final String ADMIN = "ADMIN";
	public static final String RESPONSE_SUCCESS_FLAG = "1";
	public static final String RESPONSE_FAILURE_FLAG = "-1";
	public static final String RESPONSE_USER_NOT_REGISTER_FLAG = "2";
	public static final String SUCCESS = "SUCESS";
	public static final String FAILURE = "FAIL";
	public static final String YES = "Y";
	public static final String NO = "N";
	
	public static final String INPUT_JSON = "INPUT_JSON ";
	public static final String OUTPUT_JSON = "OUTPUT_JSON";

	public static final int RECORD_STATUS_AVAILABLE = 1;
	public static final int RECORD_STATUS_DELETED = 0;

	public static final String FORGOTPASSWORD = "FP";
	public static final String NEWUSER = "N";
	public static final String UPLOAD_TYPE_PROFILE_PIC = "Profile_Picture";
	public static final String UPLOAD_TYPE_CLIENT_INFO = "Client_Info";
	public static final String UPLOAD_TYPE_CLIENT_AGGREMENT = "AGREEMENT";
	public static final String UPLOAD_TYPE_CLIENT_LOGO = "LOGO";
	public static final String CLIENT_DELETED_FILES = "DELETED_FILES";
	public static final String CUST_WHICH_ACTIVED_LICENSE = "CUST_WHICH_ACTIVED_LICENSE";
	public static final String CUST_NOT_ACTIVED_LICENSE = "CUST_NOT_ACTIVED_LICENSE";

	public static final String SALT_KEY = "SALT_KEY";
	public static final String SALT_KEY_VALUE = "galaxy_SG_e3p7Ppdj";

	public static final String TAG = "TAG";

	public static final String ALL = "0";

	public static final int ACTIVE_USER = 1;
	public static final int INACTIVE_USER = 0;

	public static final int CLIENT_INACTIVE = 0;
	public static final int CLIENT_ACTIVE = 1;
	public static final int CLIENT_INPROCESS = 2;

	public static final int AGREEMENT_INACTIVE = 0;
	public static final int AGREEMENT_ACTIVE = 1;

	public static final int SUBSCRIPTION_INACTIVE = 0;
	public static final int SUBSCRIPTION_ACTIVE = 1;
	public static final int SUBSCRIPTION_SUSPEND = 2;
	public static final int SUBSCRIPTION_TERMINATE = 3;

	public static final String CACHE_SERVER_PORT = "CACHE.SERVER.PORT.NO";
	public static String CACHE_SERVER_IP = "CACHE.SERVER.IP";

	public static int CACHE_SERVER_PORT_NO = 6379;

	public static final String LOGID = "logID";
	public static final String JSON = "JSON";
	public static final String XML = "XML";
	public static final String REQUESTFORMAT = "requestFormat";

	public static String CONTROLLER_SERVICE_NAME = "controller";

	public static final String LOGIN_ATTEMPT = "LOGIN_ATTEMPT";


	public static final String EMAIL_MESSAGE_BODY_SEPARATOR = "~";
	public static final String EMAIL_SOURCE_LICENSEEXPIRY = "LicenseExpiry";

	public static String USER_TYPE_NORMAL = "NORMAL USER";
	public static String USER_TYPE_ADMIN = "ADMIN USER";

	public static String NOTIFICATION_TYPE = "NOTIFICATION_TYPE";
	public static String NOTIFICATION_TYPE_MAIL = "MAIL";
	public static String NOTIFICATION_TYPE_SMS = "SMS";
	public static String SUBJECT = "SUBJECT";
	public static String SOURCE = "SOURCE";
	public static String RECIPIENTIDS = "RECIPIENTIDS";
	public static String MESSAGEBODY = "MessageBody";
	public static String NOTIFICATION_SEND_JOB = "NotificationSendJob";
	public static String LICENSE_CHECK_JOB = "LicenseCheckJob";

	public static String LOGIN_TYPE_TRADITIONAL = "TRADITIONAL";
	public static String LOGIN_TYPE_OTP = "OTP";
	public static String LOGIN_TYPE_LDAP = "LDAP";

	public static final String SEARCH_USER = "USER";
	public static final String SEARCH_CLIENT = "CLIENT";
	public static final String SEARCH_AGREEMENT = "AGREEMENT";

	public static final String SUCCESSS_CODE  = "0000";
	public static  final String FAILURE_CODE  = "1111";
	
	//ITEM MASTER RELATED CONSTANTS
	public static final String ITEM_CODE = "itemCodd";

	//LOGGING CODES 
	public static final String CUSTOMER_MASTER_LOGID = "100001";
	
	//API ACTION
	public static final String ACTION_ADD = "ADD";
	public static final String ACTION_DELETE = "DELETE";
	public static final String ACTION_UPDATE = "UPDATE";
}
