package com.ims.validation
;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;


@Service
public class Validation {

	private static final String USER_FIRST_NAME_NULL = "Please enter user first name";
	private static final String USER_LAST_NAME_NULL = "Please enter user last name";
	private static final String DEPT_NAME_NULL = "Please enter department name";
	private static final String USER_LENGTH = "User Name cannot be more than 50 Characters";
	private static final String USER_NOT_ACTIVE = "User is not active.";
	private static final String PASSWORD_NOT_ALLOWED = "Password not allowed.";

	private static final String EMAIL_NULL = "Please enter Email ID";
	private static final String MOBILE_NULL = "Please enter Mobile No.";

	private static final String CONFIRM_PASSWORD_NULL = "Please enter confirm password";
	private static final String PASSWORD_NULL = "Please enter password";
	private static final String PASSWORD_LENGTH = "Password cannot be more than 15 Characters";
	private static final String PASSWORD_CONFIRM_SAME = "Password and Confirm Password should be same";

	private boolean checkUserNameLength(String name, int length) {
		if (name.trim().length() > length) {
			return true;
		}
		return false;
	}

	private boolean checkPasswordLength(String password, int length) {
		if (password.trim().length() > length) {
			return true;
		}
		return false;
	}

	private boolean confirmPassword(String password, String confirmPassword) {
		if (!password.trim().equals(confirmPassword.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public String validatePassword(String password) {
		String msg = null;
		if (password == "" || password == null) {
			msg = " Password validation failed.Password can not be blank or null.";
		} else if (password.length() < 8) {
			msg = " Password validation failed.Password Length must be minimum 8 characters.";
		} else if (!(password.chars().anyMatch(Character::isUpperCase))) {
			msg = "Password validation failed.Password must contain a capital letter.";
		} else if (!(password.chars().anyMatch(Character::isLowerCase))) {
			msg = "Password validation failed.Password must contain a lower case letter.";
		} else if (!(password.matches(".*\\d.*"))) {
			msg = "Password validation failed.Password must contain a digit.";
		
		} else {
			Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(password);
			if (!m.find())
				msg = "Password validation failed.Password must contain a special character.";
		}

		return msg;
	}

}
