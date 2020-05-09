package com.ims.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ims.beans.EnquiryMaster;
import com.ims.beans.FinalResponseBean;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.RandomNumberGenerator;
import com.ims.service.EnquiryService;

@RestController
public class EnquiryController {


	private static final Logger LOG = LogManager.getFormatterLogger();
	
	@Autowired
	public EnquiryService enquiryService;

	@RequestMapping(path=RestMappingProvider.ENQUIRY, method= RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<EnquiryMaster> addEnquiry(@RequestBody EnquiryMaster enquiry,
			@PathVariable("actionType") String actionType){
		
		System.out.println(" customer supplier: " + new Gson().toJson(enquiry, EnquiryMaster.class));
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<EnquiryMaster> finalResponseBean = new FinalResponseBean<EnquiryMaster>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = enquiryService.addEnquiry(logId, enquiry, actionType);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);

			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);

		} finally {

		}
		long endTime = System.currentTimeMillis();
		LOG.info(logId + CommonConstants.EXEC_TIME + (endTime - startTime));
		LOG.info(logId + MessageConstants.SENDING_RESPONSE);
		return finalResponseBean;
	}
	
	@RequestMapping(path=RestMappingProvider.ENQUIRY, method= RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<EnquiryMaster> getEnquiry(){
		
//		System.out.println(" customer supplier: " + new Gson().toJson(enquiry, EnquiryMaster.class));
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<EnquiryMaster> finalResponseBean = new FinalResponseBean<EnquiryMaster>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = enquiryService.getEnquiry(logId);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);

			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);

		} finally {

		}
		long endTime = System.currentTimeMillis();
		LOG.info(logId + CommonConstants.EXEC_TIME + (endTime - startTime));
		LOG.info(logId + MessageConstants.SENDING_RESPONSE);
		return finalResponseBean;
	}
}
