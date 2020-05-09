package com.ims.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ResourceUtils;

import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;

public class ResourceReaderUtil {

	public static String PROPERTY_FILE = "configuration/application.properties";
	public static String LOG4J_PROPERTY_FILE = "configuration/log4j.properties";
	public static String SEPAROTOR = File.separator;

	private static final Logger log = LogManager.getFormatterLogger();

	public static Properties fetchProperties(String filePath, String logID) {
		Properties properties = new Properties();
		File file = null;
		InputStream in = null;
		try {
			file = ResourceUtils.getFile(filePath);
			in = new FileInputStream(file);
			properties.load(in);

		} catch (IOException e) {
			properties = null;
			log.error(logID + CommonConstants.EXCEPTION_STRING_START);
			log.error(logID + "Error occured while reading property file!");
			log.error(logID + e);
			log.error(logID + CommonConstants.EXCEPTION_STRING_END);
		} finally {
			file = null;
			in = null;
		}
		return properties;
	}

	public byte[] getKey() throws URISyntaxException, IOException {
		System.out.println("---------------------");
		/*
		 * this.getClass(); URI uri =
		 * this.getClass().getResource("/application.properties").toURI(); Path
		 * path = Paths.get(uri); byte[] readAllBytes =
		 * Files.readAllBytes(path); // byte[] readAllBytes =
		 * Files.readAllBytes(Paths.get(this.getClass().getResource(
		 * "/application.properties").toURI())); for (int i = 0; i <
		 * readAllBytes.length; i++) { System.out.println(readAllBytes[i]); }
		 * return readAllBytes;
		 */
		File file = ResourceUtils.getFile(PROPERTY_FILE);
		String content = new String(Files.readAllBytes(file.toPath()));
		System.out.println(content);
		return null;
	}

}
