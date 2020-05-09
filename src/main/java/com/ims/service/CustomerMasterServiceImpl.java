package com.ims.service;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.CustomerSupplier;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.ItemMaster;
import com.ims.beans.Response;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.dao.CustomerMasterDAO;

@Service
public class CustomerMasterServiceImpl implements CustomerMasterService {

	private static final Logger LOG = LogManager.getFormatterLogger();

	@Autowired
	public CustomerMasterDAO customerMasterDAO;

	@Override
	public FinalResponseBean<CustomerSupplier> addCustomer(String logId, CustomerSupplier customerSupplier, String actionType) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			/* SETTING CREATED AND UPDATED DATE*/
			//customerSupplier.setCsCreatedBy(csCreatedBy);
			if(StringUtils.equals(CommonConstants.ACTION_ADD, actionType)) {
				customerSupplier.setCsDeletedFlg("N");
			}else if(StringUtils.equals(CommonConstants.ACTION_UPDATE, actionType)) {
				customerSupplier.setCsDeletedFlg("N");
			}else if(StringUtils.equals(CommonConstants.ACTION_DELETE, actionType)) {
				customerSupplier.setCsDeletedFlg("Y");
			}
			finalResponseBean = customerMasterDAO.addCustomer(logId, customerSupplier);
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

	@Override
	public FinalResponseBean<CustomerSupplier> getCustomer(String logId, int custCode) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterDAO.getCustomer(logId, custCode);
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

	@Override
	public FinalResponseBean<CustomerSupplier> getAllCustomers(String logId) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterDAO.getAllCustomers(logId);
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

	@Override
	public FinalResponseBean<CustomerSupplier> deleteCustomer(String logId, CustomerSupplier CustomerSupplier) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterDAO.deleteCustomer(logId, CustomerSupplier);
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

	@Override
	public FinalResponseBean<CustomerSupplier> updateCustomer(String logId, CustomerSupplier CustomerSupplier) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = customerMasterDAO.updateCustomer(logId, CustomerSupplier);
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
