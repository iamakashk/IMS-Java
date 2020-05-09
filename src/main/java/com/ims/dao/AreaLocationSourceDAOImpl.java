package com.ims.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ims.beans.AreaLocation;
import com.ims.beans.CustomerSupplier;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Response;
import com.ims.beans.Source;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.HibernateUtil;

@Repository
public class AreaLocationSourceDAOImpl implements AreaLocationSourceDAO {

	private static final Logger LOG = LogManager.getFormatterLogger();
	
	@Override
	public FinalResponseBean<AreaLocation> addAreaLocationDAO(String logId, AreaLocation areaLocation) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<AreaLocation> finalResponseBean = new FinalResponseBean<AreaLocation>();
		List<AreaLocation> areaLocations = new ArrayList<AreaLocation>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			session.save(areaLocation);
			session.getTransaction().commit();

			AreaLocation areaLocation2 = new AreaLocation();
			areaLocation2 = session.get(AreaLocation.class, areaLocation.getId());
			areaLocations.add(areaLocation2);					
			finalResponseBean.setData(areaLocations);
			
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_GET_ALL_SUCCESS);
			finalResponseBean.setResponse(responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.FAILURE_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_ERROR);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return finalResponseBean;
	}

	@Override
	public FinalResponseBean<AreaLocation> getAreaLocationDAO(String logId) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<AreaLocation> finalResponseBean = new FinalResponseBean<AreaLocation>();
		List<AreaLocation> areaLocations = new ArrayList<AreaLocation>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			Criteria criteria = session.createCriteria(AreaLocation.class);
			criteria.add(Restrictions.eq("deleted", "N"));
			
			areaLocations = (List<AreaLocation>) criteria.list();
			finalResponseBean.setData(areaLocations);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.FAILURE_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_ERROR);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return finalResponseBean;
	}

	@Override
	public FinalResponseBean<Source> addSourceDAO(String logId, Source source) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<Source> finalResponseBean = new FinalResponseBean<Source>();
		List<Source> sources = new ArrayList<Source>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			session.saveOrUpdate(source);
			session.getTransaction().commit();

			AreaLocation areaLocation2 = new AreaLocation();
			Source source1 =new Source(); 
			source1 = session.get(Source.class, source.getId());
			sources.add(source1);					
			finalResponseBean.setData(sources);
			
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_GET_ALL_SUCCESS);
			finalResponseBean.setResponse(responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.FAILURE_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_ERROR);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return finalResponseBean;
	}

	@Override
	public FinalResponseBean<Source> getSourceDAO(String logId) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<Source> finalResponseBean = new FinalResponseBean<Source>();
		List<Source> sources = new ArrayList<Source>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			Criteria criteria = session.createCriteria(Source.class);
			criteria.add(Restrictions.eq("deleted", "N"));
			sources = (List<Source>) criteria.list();
			finalResponseBean.setData(sources);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.FAILURE_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_ERROR);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return finalResponseBean;
	}

}
