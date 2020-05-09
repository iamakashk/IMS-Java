package com.ims.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {

	public static final SimpleDateFormat TIME_STAMP_FORMAT = new SimpleDateFormat("yyyyMMddhhmmsss");
	public static final SimpleDateFormat CURRENT_DATE_FORMAT = new SimpleDateFormat("YYYYMMdd");
	public static final SimpleDateFormat CURRENT_TIME_FORMAT = new SimpleDateFormat("hhmmss");

	public static long getCurrentTimeStamp() {
		return Long.parseLong(TIME_STAMP_FORMAT.format(new Date()));
	}

	public static long getCurrentDate() {
		return Long.parseLong(CURRENT_DATE_FORMAT.format(new Date()));

	}

	public static long getCurrentTime() {
		return Long.parseLong(CURRENT_TIME_FORMAT.format(new Date()));
	}

}
