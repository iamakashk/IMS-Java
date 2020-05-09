package com.ims.service;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.AreaLocation;
import com.ims.beans.CustomerSupplier;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Response;
import com.ims.beans.Source;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.dao.AreaLocationSourceDAO;

@Service
public class AreaLocationSourceServiceImpl implements AreaLocationSourceService {

	private static final Logger LOG = LogManager.getFormatterLogger();
	
	@Autowired
	public AreaLocationSourceDAO areaLocationDAO;
	
	@Override
	public FinalResponseBean<AreaLocation> addAreaLocationService(String logId, AreaLocation areaLocation) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<AreaLocation> finalResponseBean = new FinalResponseBean<AreaLocation>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = areaLocationDAO.addAreaLocationDAO(logId, areaLocation);
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
	public FinalResponseBean<AreaLocation> getAreaLocationService(String logId) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<AreaLocation> finalResponseBean = new FinalResponseBean<AreaLocation>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean =	areaLocationDAO.getAreaLocationDAO(logId);
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
	public FinalResponseBean<Source> addSourceService(String logId, Source source, String actionType) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<Source> finalResponseBean = new FinalResponseBean<Source>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			if(StringUtils.equals(actionType, CommonConstants.ACTION_DELETE)) {
				LOG.info(" SETTING FLAG TO DELETE");
				source.setDeleted("Y");
			}
			finalResponseBean = areaLocationDAO.addSourceDAO(logId, source);
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
	public FinalResponseBean<Source> getSourceService(String logId) {
		long startTime = System.currentTimeMillis();

		LOG.info(logId + MessageConstants.NEW_REQUEST);
		LOG.info(logId + CommonConstants.INPUT_START);

		/* PRINT INPUT PARAMETER */
		LOG.info(logId + CommonConstants.INPUT_END);
		Response responseBean = new Response();
		FinalResponseBean<Source> finalResponseBean = new FinalResponseBean<Source>();

		try {

			/*--------------BUSINESS LOGIC------------------------------*/
			finalResponseBean = areaLocationDAO.getSourceDAO(logId);
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
