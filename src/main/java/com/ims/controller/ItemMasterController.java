package com.ims.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

import com.ims.beans.Item;
import com.ims.beans.ItemMaster;
import com.ims.beans.Response;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.RandomNumberGenerator;
import com.ims.service.ItemMasterService;

@RestController
//@Path(value = RestMappingProvider.API_VERSION)
public class ItemMasterController {

	private static final Logger LOG = LogManager.getFormatterLogger();

	@Autowired
	public ItemMasterService itemMasterService;

	@RequestMapping(path = RestMappingProvider.ITEMS_GET_ALL, method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public ItemMaster getAllItems() {

		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		ItemMaster itemMaster = new ItemMaster();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			itemMaster = itemMasterService.getAllItemsService(logId);
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
		return itemMaster;
	}

	@RequestMapping(path = RestMappingProvider.ITEMS_GET_SINGLE, method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public ItemMaster getSingleItem(@PathVariable("itemCode") int itemCode) {
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);

		ItemMaster itemMaster = new ItemMaster();
		
		try {

			itemMaster = itemMasterService.getSingleItemService(logId, itemCode);

			/*--------------BUSINESS LOGIC------------------------------*/
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
		return itemMaster;
	}

	@RequestMapping(path = RestMappingProvider.ITEMS_UPDATE_SINGLE_ITEM, method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public ItemMaster updateSingleItem(@RequestBody Item item) {
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			item.setItDeletedFlag("N");
			itemMaster = itemMasterService.updateSingleItemService(logId, item);
			
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
		return itemMaster;
	}

	@RequestMapping(path = RestMappingProvider.ITEMS_DELETE_SINGLE, method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public ItemMaster deleteSingleItem(@RequestBody Item item) {
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			item.setItDeletedFlag("Y");
			itemMaster = itemMasterService.deleteSingleItemService(logId, item);
			
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
		return itemMaster;
	}

	@RequestMapping(path = RestMappingProvider.ITEMS_CREATE_SINGLE, method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public ItemMaster addSingleItem(@RequestBody Item item) {
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			
			itemMaster = itemMasterService.createSingleItemService(logId, item);
			
			
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
		return itemMaster;
	}

	@RequestMapping(path = RestMappingProvider.ITEMS_SINGLE_ITEM_PAGINATION, method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public ItemMaster getItemWithPagination(@QueryParam("limit") String limit, @QueryParam("offset") String offset) {
		LOG.info("INSIDE PAGINATION@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+ limit  + "--"+ offset);
		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			itemMaster = itemMasterService.itemPaginationService(logId, Integer.valueOf(limit), Integer.valueOf(offset));
			
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
		return itemMaster;
	}

	@RequestMapping(path = RestMappingProvider.SAMPLE, method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin
	public ItemMaster sample() {

		long startTime = System.currentTimeMillis();
		String logId = String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
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
		return null;
	}

}
