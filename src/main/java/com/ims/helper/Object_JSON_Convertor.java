package com.ims.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ims.constant.CommonConstants;

public class Object_JSON_Convertor {

	private static final Logger LOG = LogManager.getFormatterLogger();
	private static ObjectMapper objectMapper;

	public static void convertObjectToJSON(Object object, String logId, String type) {
		try {
			if (objectMapper == null) {
				objectMapper = new ObjectMapper();
				objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			}
			String jsonString = objectMapper.writeValueAsString(object);// objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);//
			LOG.info(logId + type + ":  " + jsonString);
		} catch (JsonProcessingException e) {
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
		}
	}
}
