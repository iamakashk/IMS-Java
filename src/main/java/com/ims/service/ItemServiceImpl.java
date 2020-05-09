package com.ims.service;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.Item;
import com.ims.beans.ItemMaster;
import com.ims.beans.Response;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.dao.ItemMasterDAO;

@Service
public class ItemServiceImpl implements ItemMasterService {
	private static final Logger LOG = LogManager.getFormatterLogger();
	
	@Autowired
	public ItemMasterDAO itemMasterDAO;
	
	@Override
	public ItemMaster getAllItemsService(String logId) {
		long startTime = System.currentTimeMillis();
		
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			itemMaster = itemMasterDAO.getAllItemsDAO(logId);
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

	@Override
	public ItemMaster getSingleItemService(String logId, int itemCode) {
		long startTime = System.currentTimeMillis();
		
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {
			if(StringUtils.isEmpty(String.valueOf(itemCode))) {
				responseBean.setRespCode(CommonConstants.FAILURE_CODE);
				responseBean.setRespMsg(MessageConstants.ITEMS_NO_ITEM_FOUND);
				itemMaster.setResponse(responseBean);
			}else {
				itemMaster = itemMasterDAO.getSingleItemDAO(logId, itemCode);
			}
			
			
			/*--------------BUSINESS LOGIC------------------------------*/
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.FAILURE_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_NO_ITEM_FOUND);
			itemMaster.setResponse(responseBean);

		} finally {

		}
		long endTime = System.currentTimeMillis();
		LOG.info(logId + CommonConstants.EXEC_TIME + (endTime - startTime));
		LOG.info(logId + MessageConstants.SENDING_RESPONSE);
		return itemMaster;
	}

	@Override
	public ItemMaster updateSingleItemService(String logId, Item item) {
		long startTime = System.currentTimeMillis();
		
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			item.setItDeletedFlag("N");
			itemMaster = itemMasterDAO.updateSingleItemDAO(logId, item);
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

	@Override
	public ItemMaster deleteSingleItemService(String logId, Item item) {
		long startTime = System.currentTimeMillis();
		
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			itemMaster = itemMasterDAO.deleteSingleItemDAO(logId, item);
			
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

	@Override
	public ItemMaster createSingleItemService(String logId, Item item) {
		long startTime = System.currentTimeMillis();
		
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			item.setItDeletedFlag("N");
		    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
		    //String itTsCreated =(String) item.getItTsCreated();
		    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+ item.getItTsCreated());

			itemMaster = itemMasterDAO.createSingleItemDAO(logId, item);
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

	@Override
	public ItemMaster itemPaginationService(String logId, int limit, int offset) {
		long startTime = System.currentTimeMillis();
		
		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {
			itemMaster = itemMasterDAO.itemPaginationDAO(logId, limit, offset);
			
			/*
			 * if(StringUtils.isEmpty(String.valueOf(limit)) ||
			 * StringUtils.isEmpty(String.valueOf(offset))) {
			 * 
			 * }else if(1==1) {
			 * 
			 * }else { itemMaster = itemMasterDAO.itemPaginationDAO(logId, limit, offset); }
			 */
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

}
