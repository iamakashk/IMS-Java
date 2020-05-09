package com.ims.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.constant.CommonConstants;


public class FileReader {
	private static final Logger LOG = LogManager.getFormatterLogger();
	public static String PROPERTY_FILE = "logs/ETPLicenseServerLog.log";

	public static void main(String[] args) {
		System.out.println(getErrorLog(0, "L1"));
	}

	public static ArrayList<String> getErrorLog(int count, String logId) {
		File file = null;
		ArrayList<String> ecxeptions = new ArrayList<>();
		try {
			List<String> allLines = Files.readAllLines(Paths.get(PROPERTY_FILE));
			boolean exceptionStart = false;
			boolean exceptionEnd = false;

			LinkedList<String> exceptionLines = null;
			HashMap<Integer, LinkedList<String>> exceptionString = new HashMap<>();
			int ExceptionCount = 1;
			for (String line : allLines) {
				if (line.contains(CommonConstants.EXCEPTION_STRING_START)) {
					exceptionStart = true;
					exceptionEnd = false;
					exceptionLines = new LinkedList<>();
				}
				if (line.contains(CommonConstants.EXCEPTION_STRING_END)) {
					exceptionEnd = true;
					exceptionString.put(ExceptionCount, exceptionLines);
					ExceptionCount++;
				}

				if (exceptionStart && !exceptionEnd) {
					exceptionLines.add(line);
				}

			}

			exceptionString = exceptionString.entrySet() // Set<Entry<String,
															// String>>
					.stream() // Stream<Entry<String, String>>
					.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
							LinkedHashMap::new));

			int excAdded = 0;
			for (Entry<Integer, LinkedList<String>> entry : exceptionString.entrySet())
				if (entry.getValue().size() > 0) {
					if (excAdded < count) {
						LinkedList<String> value = entry.getValue();
						ecxeptions.addAll(entry.getValue());
						excAdded++;
					}
				}

		} catch (IOException e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
		}
		return ecxeptions;
	}
}
