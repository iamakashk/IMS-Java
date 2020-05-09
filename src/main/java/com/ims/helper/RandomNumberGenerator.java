package com.ims.helper;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;


/**
 * This class is used to generate random number
 * 
 * @author BSABH03
 *
 */
public class RandomNumberGenerator {

	private static final int DEF_COUNT = 4;

	/**
	 * This method is used to generate the random number
	 * 
	 * @return String
	 */
	public static String generateRandomNumberForLOG() {
		Random rand = new Random();
		int logId = rand.nextInt() & Integer.MAX_VALUE;
		Date date = new Date();
		Format formatter = new SimpleDateFormat("ddMMyyhhmmss");
		String dateAfterFormat = formatter.format(date);
		return "LG" + dateAfterFormat + "_" + logId + "::";
	}

	public static void main(String[] args) {
		/*
		 * System.out.println("generatePassword: " + generatePassword());
		 * System.out.println("generateActivationKey: " +
		 * generateActivationKey()); System.out.println("generateResetKey: " +
		 * generateResetKey());
		 */

	}

	/**
	 * This method is used to generate the random number
	 * 
	 * @return String
	 */
	public static long generateRandomNumber() {
		Random rand = new Random();
		long rendomNumber = rand.nextInt() & Integer.MAX_VALUE;
		return rendomNumber;
	}

	/***********************************************************************/

	/**
	 * Generate an activation key.
	 *
	 * @return the generated activation key
	 */
	public static long generateRandomNumber(int length) {
		return Long.valueOf(RandomStringUtils.randomNumeric(length));
	}

	/**
	 * Generate a password.
	 *
	 * @return the generated password
	 */
	public static String generatePassword() {
		return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
	}

	/**
	 * Generate an activation key.
	 *
	 * @return the generated activation key
	 */
	public static String generateActivationKey() {
		return RandomStringUtils.randomNumeric(DEF_COUNT);
	}

	/**
	 * Generate a reset key.
	 *
	 * @return the generated reset key
	 */
	public static String generateResetKey() {
		return RandomStringUtils.randomNumeric(DEF_COUNT);
	}

}
