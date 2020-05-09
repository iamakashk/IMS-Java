package com.ims.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.ims.beans.CustomerAddress;
import com.ims.beans.CustomerSupplier;
import com.ims.beans.CustomerSupplier;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Item;
import com.ims.beans.ItemMaster;
import com.ims.beans.Response;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.HibernateUtil;
import com.mysql.cj.xdevapi.CreateIndexParams;

@Repository
public class CustomerMasterDAOImpl implements CustomerMasterDAO {
	private static final Logger LOG = LogManager.getFormatterLogger();

	@Override
	public FinalResponseBean<CustomerSupplier> addCustomer(String logId, CustomerSupplier customerSupplier) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		List<CustomerSupplier> CustomerSuppliersList = new ArrayList<CustomerSupplier>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			session.saveOrUpdate(customerSupplier);
			session.getTransaction().commit();
			
			int customerId = customerSupplier.getCsCustSupplrCode();
			
			List<CustomerAddress> customerAddresses = customerSupplier.getCustomerAddress();
			
			for(int i = 0 ; i < customerAddresses.size(); i++) {
				session.beginTransaction();
				CustomerAddress address = customerAddresses.get(i);
				address.setCsadCustSupplrCode(customerId);
				session.saveOrUpdate(address);
				session.getTransaction().commit();
			}
			CustomerSupplier CustomerSupplierBean = new CustomerSupplier();
			CustomerSupplierBean = session.get(CustomerSupplier.class, customerSupplier.getCsCustSupplrCode());
			CustomerSuppliersList.add(CustomerSupplierBean);					
			finalResponseBean.setData(CustomerSuppliersList);
			
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
	public FinalResponseBean<CustomerSupplier> getCustomer(String logId, int custCode) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		List<CustomerSupplier> customerSupplier = new ArrayList<CustomerSupplier>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			
//			LOG.info(" customer supplier: ", session.createQuery(" from CustomerSupplier").list());
			

			CustomerSupplier CustomerSupplierBean = new CustomerSupplier();
			CustomerSupplierBean = session.get(CustomerSupplier.class, custCode);
			customerSupplier.add(CustomerSupplierBean);					
			
			
			Criteria criteria = session.createCriteria(CustomerAddress.class);
			criteria.add(Restrictions.eq("csadCustSupplrCode", custCode));
			List<CustomerAddress> customerAddresses = criteria.list();
			CustomerSupplierBean.setCustomerAddress(customerAddresses);
			finalResponseBean.setData(customerSupplier);
			
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
	public FinalResponseBean<CustomerSupplier> getAllCustomers(String logId) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		List<CustomerSupplier> customerSuppliersList = new ArrayList<CustomerSupplier>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			
//			Query query = session.createQuery(" from CustomerSupplier");
			Criteria criteria = session.createCriteria(CustomerSupplier.class);
			criteria.add(Restrictions.eq("csDeletedFlg", "N"));
			
			//LOG.info("query.list() >>>>>>>>>>>>> "+ query.list());
			CustomerSupplier customerSupplier =(CustomerSupplier) criteria.list().get(0);
			String queryStr  = new Gson().toJson(customerSupplier, CustomerSupplier.class);
			LOG.info("query.list() >>>>>>>>>>>>> "+ queryStr);
			customerSuppliersList = (List<CustomerSupplier>) criteria.list();
			finalResponseBean.setData(customerSuppliersList);
			
			
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
	public FinalResponseBean<CustomerSupplier> deleteCustomer(String logId, CustomerSupplier customerSupplier) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		List<CustomerSupplier> CustomerSuppliersList = new ArrayList<CustomerSupplier>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			session.save(customerSupplier);
			session.getTransaction().commit();

			CustomerSupplier CustomerSupplierBean = new CustomerSupplier();
			CustomerSupplierBean = session.get(CustomerSupplier.class, customerSupplier.getCsCustSupplrCode());
			CustomerSuppliersList.add(CustomerSupplierBean);					
			finalResponseBean.setData(CustomerSuppliersList);
			
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
	public FinalResponseBean<CustomerSupplier> updateCustomer(String logId, CustomerSupplier customerSupplier) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<CustomerSupplier> finalResponseBean = new FinalResponseBean<CustomerSupplier>();
		List<CustomerSupplier> CustomerSuppliersList = new ArrayList<CustomerSupplier>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			session.saveOrUpdate(customerSupplier);
			
			int customerId = customerSupplier.getCsCustSupplrCode();
			
			List<CustomerAddress> customerAddresses = customerSupplier.getCustomerAddress();
			
			for(int i = 0 ; i < customerAddresses.size(); i++) {
				CustomerAddress address = customerAddresses.get(i);
				address.setCsadCustSupplrCode(customerId);
				session.saveOrUpdate(address);
			}
			CustomerSupplier CustomerSupplierBean = new CustomerSupplier();
			CustomerSupplierBean = session.get(CustomerSupplier.class, customerSupplier.getCsCustSupplrCode());
			CustomerSuppliersList.add(CustomerSupplierBean);					
			finalResponseBean.setData(CustomerSuppliersList);
			
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_GET_ALL_SUCCESS);
			finalResponseBean.setResponse(responseBean);
			session.getTransaction().commit();
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
