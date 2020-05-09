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
import com.ims.beans.CustomerSupplier;
import com.ims.beans.FinalResponseBean;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.RandomNumberGenerator;
import com.ims.service.CustomerMasterService;

@RestController
//@Path(value = RestMappingProvider.API_VERSION)
public class CustomerMasterController {

	private static final Logger LOG = LogManager.getFormatterLogger();
	
	@Autowired
	public CustomerMasterService customerMasterService;

	@RequestMapping(path=RestMappingProvider.CUSTOMER_ADD, method= RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<CustomerSupplier> addCustomer(@RequestBody CustomerSupplier customerSupplier,
			@PathVariable("actionType") String actionType){
		
		System.out.println(" customer supplier: " + new Gson().toJson(customerSupplier, CustomerSupplier.class));
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterService.addCustomer(CommonConstants.CUSTOMER_MASTER_LOGID, customerSupplier,actionType);
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
	@RequestMapping(path=RestMappingProvider.CUSTOMER_UPDATE, method= RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<CustomerSupplier> updateCustomer(@RequestBody CustomerSupplier CustomerSupplier){
		
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterService.updateCustomer(CommonConstants.CUSTOMER_MASTER_LOGID, CustomerSupplier);
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
	
	@RequestMapping(path=RestMappingProvider.CUSTOMER_DELETE, method= RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<CustomerSupplier> deleteCustomer(@RequestBody CustomerSupplier CustomerSupplier){
		
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterService.deleteCustomer(CommonConstants.CUSTOMER_MASTER_LOGID, CustomerSupplier);
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

	@RequestMapping(path = RestMappingProvider.CUSTOMER_GET_ALL, method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<CustomerSupplier> getAllCustomer(){
		
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterService.getAllCustomers(CommonConstants.CUSTOMER_MASTER_LOGID);
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
	
	@RequestMapping(path=RestMappingProvider.CUSTOMER_GET_SINGLE, method= RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public FinalResponseBean<CustomerSupplier> getCustomer(@PathVariable("custCode") int custCode){
		
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterService.getCustomer(CommonConstants.CUSTOMER_MASTER_LOGID, custCode);
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
