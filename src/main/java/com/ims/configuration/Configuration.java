package com.ims.configuration;

import java.util.Set;

import com.ims.helper.RedisUtil;


public class Configuration {

	public static String CACHE_SERVER_PORT_NO = "CACHE.SERVER.PORT.NO";
	public static String CACHE_SERVER_IP = "CACHE.SERVER.IP";
	public static String LDAP_SERVER = "LDAP.SERVER";
	public static String UI_SERVER_IP = "UI.SERVER.IP";
	public static String OTP_EXPIRE_AFTER_SECOND = "OTP.EXPIRE.AFTER.SECOND";
	public static String DB_URL = "DB.URL";
	public static String DB_USER_NAME = "DB.USER.NAME";
	public static String DB_USER_PASSWORD = "DB.USER.PASSWORD";
	public static String MAIL_SMTP_PORT = "mail.smtp.port";
	public static String MAIL_USER_NAME = "mail.user.name";
	public static String MAIL_USER_PASSWORD = "mail.user.password";

	public static String SMS_URL = "sms.url";
	public static String SMS_USER_NAME = "sms.user.name";
	public static String SMS_USER_PASSWORD = "sms.user.password";

	/**
	 * The method sets the read property file values into the global HashMap.
	 * 
	 */
	public static void setParameter(String p_AttributeKey, String p_AttributeValue, String logId) {

		RedisUtil.INSTANCE.add(p_AttributeKey, p_AttributeValue, logId);
	}

	/**
	 * The method returns the value associated with the provided attribute key.
	 */
	public static String getParameter(String p_AttributeKey, String logId) {
		String value = null;
		Set<String> valueByKey = RedisUtil.INSTANCE.getValueByKey(p_AttributeKey, logId);

		if (valueByKey != null && !valueByKey.isEmpty()) {
			value = valueByKey.iterator().next();
		}
		return value;
	}

}
