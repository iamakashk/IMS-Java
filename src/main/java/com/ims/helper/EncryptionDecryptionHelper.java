package com.ims.helper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.constant.CommonConstants;

public class EncryptionDecryptionHelper {
	private static final Logger LOG = LogManager.getFormatterLogger();
	private static SecretKeySpec secretKey;
	private static byte[] key;

	public static boolean setKey(String logID) {
		boolean isKeySet = false;
		MessageDigest sha = null;
		try {
			Set<String> Keys = RedisUtil.INSTANCE.getValueByKey(CommonConstants.SALT_KEY, logID);
			if (Keys != null && !Keys.isEmpty()) {
				String myKey = Keys.iterator().next();
				key = myKey.getBytes("UTF-8");
				sha = MessageDigest.getInstance("SHA-1");
				key = sha.digest(key);
				key = Arrays.copyOf(key, 16);
				secretKey = new SecretKeySpec(key, "AES");
				isKeySet = true;
			} else {
				LOG.info("Salt key not found in redis.");
				isKeySet = false;
			}
		} catch (NoSuchAlgorithmException e) {
			LOG.error(CommonConstants.EXCEPTION_STRING_START);
			LOG.error("error in setKey: " + e);
			LOG.error(CommonConstants.EXCEPTION_STRING_END);
			isKeySet = false;
		} catch (UnsupportedEncodingException e) {
			LOG.error(CommonConstants.EXCEPTION_STRING_START);
			LOG.error("error in setKey: " + e);
			LOG.error(CommonConstants.EXCEPTION_STRING_END);

			isKeySet = false;
		}
		return isKeySet;

	}

	public static String encrypt(String strToEncrypt, String logID) {
		try {
			boolean setKey = setKey(logID);
			if (setKey) {
				Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
			} else {
				return null;
			}

		} catch (Exception e) {
			LOG.error(logID + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logID + "Error while encrypting: " + e);
			LOG.error(logID + CommonConstants.EXCEPTION_STRING_END);
		}
		return null;
	}

	public static String decrypt(String strToDecrypt, String logID) {
		try {
			boolean setKey = setKey(logID);
			if (setKey) {
				Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
			} else {
				return null;
			}
		} catch (Exception e) {
			LOG.error(logID + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logID + "Error while decrypting: " + e);
			LOG.error(logID + CommonConstants.EXCEPTION_STRING_END);
		}
		return null;
	}

	public static void main(String[] args) {
		// final String secretKey = "galaxy_SG_e3p7Ppdj";
		String log = "LG001";
		// RedisUtil.INSTANCE.add(CommonConstants.SALT_KEY,
		// "galaxy_SG_e3p7Ppdj");

		String originalString = "Etp@123456";
		String encryptedString = EncryptionDecryptionHelper.encrypt(originalString, log);
		String decryptedString = EncryptionDecryptionHelper.decrypt(encryptedString, log);

		System.out.println("originalString: " + originalString);
		System.out.println("encryptedString: " + encryptedString);
		System.out.println("decryptedString: " + decryptedString);

	}

	private void validatePassword() {
		String pwd = "Etp@123456";
		if (pwd.length() < 8) {
			System.out.println("password Length is less than 8 digit");
		}

		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(pwd);
		boolean b = m.find();
		if (b) {
			System.out.println("There is a special character in my string");
		}

		boolean anyMatch = pwd.chars().anyMatch(Character::isUpperCase);
		if (anyMatch) {
			System.out.println("There is a upper case character in my string");
		}
		boolean anyMatch1 = pwd.matches(".*\\d.*");
		if (anyMatch1) {
			System.out.println("There is a digit in my string");
		}
	}

}
