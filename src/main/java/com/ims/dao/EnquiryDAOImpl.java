package com.ims.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ims.beans.EnquiryDetails;
import com.ims.beans.EnquiryMaster;
import com.ims.beans.EnquiryMasterGet;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Response;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.HibernateUtil;

@Repository
public class EnquiryDAOImpl implements EnquiryDAO {

	private static final Logger LOG = LogManager.getFormatterLogger();
	
	@Override
	public FinalResponseBean<EnquiryMaster> addEnquiry(String logId, EnquiryMaster enquiry,
			String actionType) {
		Session session = null;
		
		Response responseBean = new Response();
		FinalResponseBean<EnquiryMaster> finalResponseBean = new FinalResponseBean<EnquiryMaster>();
		List<EnquiryMaster> enquiryList = new ArrayList<EnquiryMaster>();
//		EnquiryDetails details1 = new EnquiryDetails();
//		EnquiryMaster enquiryMaster1 = new EnquiryMaster();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			
			session.saveOrUpdate(enquiry);
			//session.getTransaction().commit();
			
//			Object[] arr = enquiry.getEnquiryDetails().toArray();
//			List<Object> details = Arrays.asList(arr);
			List<EnquiryDetails> details = enquiry.getEnquiryDetails();
			
			for(int i = 0 ; i < details.size(); i++) {
				session.beginTransaction();
				
				EnquiryDetails singleEnquiry =(EnquiryDetails) details.get(i);
				singleEnquiry.setEnquiryId(enquiry.getEnquiryId());
				session.saveOrUpdate(singleEnquiry);
				//session.getTransaction().commit();
			}
			session.getTransaction().commit();
			

			EnquiryMaster enquiryMaster = new EnquiryMaster();
			enquiryMaster = session.get(EnquiryMaster.class, enquiry.getEnquiryId());
			enquiryList.add(enquiryMaster);
								
			finalResponseBean.setData(enquiryList);
			
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
	public FinalResponseBean<EnquiryMaster> getEnquiry(String logId) {
		Session session = null;
		
		Response responseBean = new Response();
		FinalResponseBean<EnquiryMaster> finalResponseBean = new FinalResponseBean<EnquiryMaster>();
		List<EnquiryMaster> enquiryList = new ArrayList<EnquiryMaster>();
		Criteria criteria = null;
		try {
			
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			criteria = session.createCriteria(EnquiryMasterGet.class);
			criteria.add(Restrictions.eq("deletedFlag","N"));
			criteria.createAlias("enquiryDetails", "enquiryDetails");
			criteria.add(Restrictions.eq("enquiryDetails.deletedFlag","N"));
			enquiryList = (List<EnquiryMaster> ) criteria.list();
			
			
//			Query query  =session.createQuery("from EnquiryMaster");
//			enquiryList = query.list();

			finalResponseBean.setData(enquiryList);
			
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

}
