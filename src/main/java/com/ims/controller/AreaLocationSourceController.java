package com.ims.controller;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ims.beans.AreaLocation;
import com.ims.beans.City;
import com.ims.beans.AreaLocation;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Response;
import com.ims.beans.Source;
import com.ims.beans.State;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.HibernateUtil;
import com.ims.helper.RandomNumberGenerator;
import com.ims.service.AreaLocationSourceService;

@RestController
public class AreaLocationSourceController {

	private static final Logger LOG = LogManager.getFormatterLogger();

	@Autowired
	public AreaLocationSourceService areaLocationSourceService;
	
	@RequestMapping(path = RestMappingProvider.AREA_LOCATION, method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<AreaLocation> addAreaLocation(@RequestBody AreaLocation areaLocation) {
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<AreaLocation> finalResponseBean = new FinalResponseBean<AreaLocation>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = areaLocationSourceService.addAreaLocationService(logId, areaLocation);
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

	@RequestMapping(path = RestMappingProvider.AREA_LOCATION, method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<AreaLocation> getAreaLocations() {
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<AreaLocation> finalResponseBean = new FinalResponseBean<AreaLocation>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean =  areaLocationSourceService.getAreaLocationService(logId);
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

	@RequestMapping(path = RestMappingProvider.CUSTOMER_SOURCE, method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<Source> addModifySource(@RequestBody Source source, @PathVariable("actionType") String actionType) {
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<Source> finalResponseBean = new FinalResponseBean<Source>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			System.out.println(" ACTION TYPE ::::::::::::: "+ actionType);
			finalResponseBean = areaLocationSourceService.addSourceService(logId, source , actionType);
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

	@RequestMapping(path = RestMappingProvider.CUSTOMER_SOURCE, method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<Source> getCustomerSource(@PathVariable("actionType") String actionType) {

		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<Source> finalResponseBean = new FinalResponseBean<Source>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = areaLocationSourceService.getSourceService(logId);
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
