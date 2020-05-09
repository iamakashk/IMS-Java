package com.ims.service;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.CustomerSupplier;
import com.ims.beans.EnquiryMaster;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Response;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.dao.CustomerMasterDAO;
import com.ims.dao.EnquiryDAO;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	private static final Logger LOG = LogManager.getFormatterLogger();

	@Autowired
	public EnquiryDAO enquiryDAO;

	
	@Override
	public FinalResponseBean<EnquiryMaster> addEnquiry(String logId, EnquiryMaster enquiry,
			String actionType) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<EnquiryMaster> finalResponseBean = new FinalResponseBean<EnquiryMaster>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			/* SETTING CREATED AND UPDATED DATE*/
			
			//customerSupplier.setCsCreatedBy(csCreatedBy);
			if(StringUtils.equals(CommonConstants.ACTION_ADD, actionType)) {
				enquiry.setDeletedFlag("N");
			}else if(StringUtils.equals(CommonConstants.ACTION_UPDATE, actionType)) {
				enquiry.setDeletedFlag("N");
			}else if(StringUtils.equals(CommonConstants.ACTION_DELETE, actionType)) {
				enquiry.setDeletedFlag("Y");
			}
			finalResponseBean = enquiryDAO.addEnquiry(logId, enquiry, actionType);
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
	public FinalResponseBean<EnquiryMaster> getEnquiry(String logId) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<EnquiryMaster> finalResponseBean = new FinalResponseBean<EnquiryMaster>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			/* SETTING CREATED AND UPDATED DATE*/
			//customerSupplier.setCsCreatedBy(csCreatedBy);
//			if(StringUtils.equals(CommonConstants.ACTION_ADD, actionType)) {
//				customerSupplier.setCsDeletedFlg("N");
//			}else if(StringUtils.equals(CommonConstants.ACTION_UPDATE, actionType)) {
//				customerSupplier.setCsDeletedFlg("N");
//			}else if(StringUtils.equals(CommonConstants.ACTION_DELETE, actionType)) {
//				customerSupplier.setCsDeletedFlg("Y");
//			}
			finalResponseBean = enquiryDAO.getEnquiry(logId);
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
