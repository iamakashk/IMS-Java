package com.ims.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ims.beans.Item;
import com.ims.beans.ItemMaster;
import com.ims.beans.Response;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.HibernateUtil;

@Repository
public class ItemMasterDAOImpl implements ItemMasterDAO {
	private static final Logger LOG = LogManager.getFormatterLogger();

	@Override
	public ItemMaster getAllItemsDAO(String logId) {
		Session session = null;
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		List<Item> itemsList = new ArrayList();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			itemsList = session.createQuery("from Item where IT_DELETED_FLG='N'").list();
			itemMaster.setItem(itemsList);
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_GET_ALL_SUCCESS);
			itemMaster.setResponse(responseBean);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.FAILURE_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEMS_GET_ERROR);
			itemMaster.setResponse(responseBean);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return itemMaster;
	}

	@Override
	public ItemMaster getSingleItemDAO(String logId, int itemCode) {
		Session session = null;
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		List<Item> itemList = new ArrayList<Item>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			Item item = session.get(Item.class, itemCode);
			LOG.info("----------------------$$$$$$$$$$$$$ "+ item);
			itemList.add(item);
			itemMaster.setItem(itemList);
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_GET_SINGLE_SUCCESS);
			itemMaster.setResponse(responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.FAILURE_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEMS_GET_ERROR);
			itemMaster.setResponse(responseBean);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return itemMaster;
	}

	@Override
	public ItemMaster updateSingleItemDAO(String logId, Item item) {
		Session session = null;
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		List<Item> itemList = new ArrayList<Item>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			session.saveOrUpdate(item);
			session.getTransaction().commit();
			Item item2 = session.get(Item.class, item.getItItemCode());
			itemList.add(item);
			itemMaster.setItem(itemList);
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_UPDATE_SUCCESS);
			itemMaster.setResponse(responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_UPDATE_ERROR);
			itemMaster.setResponse(responseBean);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return itemMaster;
	}

	@Override
	public ItemMaster deleteSingleItemDAO(String logId, Item item) {
		Session session = null;
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			session.saveOrUpdate(item);
			session.getTransaction().commit();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_UPDATE_SUCCESS);
			itemMaster.setResponse(responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_UPDATE_ERROR);
			itemMaster.setResponse(responseBean);
		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return itemMaster;
	}

	@Override
	public ItemMaster createSingleItemDAO(String logId, Item item) {
		Session session = null;
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		List<Item> itemList = new ArrayList<Item>();

		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			session.save(item);
			session.getTransaction().commit();

			Item itemResponse = session.get(Item.class, item.getItItemCode());
			itemList.add(itemResponse);
			itemMaster.setItem(itemList);
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_GET_ALL_SUCCESS);
			itemMaster.setResponse(responseBean);

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
		return itemMaster;
	}

	@Override
	public ItemMaster itemPaginationDAO(String logId, int limit, int offset) {
		Session session = null;
		Response responseBean = new Response();
		ItemMaster itemMaster = new ItemMaster();
		List<Item> itemList = new ArrayList<Item>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			Query query = session.createQuery(" from item  LIMIT "+limit+ " OFFSET " + offset);
			/*
			 * query.setParameter("limit", limit); query.setParameter("offset", offset);
			 */
			itemList = query.list();
			itemMaster.setItem(itemList);
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_GET_ALL_SUCCESS);
			itemMaster.setResponse(responseBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			responseBean.setRespCode(CommonConstants.FAILURE_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEMS_GET_ERROR);
			itemMaster.setResponse(responseBean);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return itemMaster;
	}

	public ItemMaster sample(String logId) {
		Session session = null;
		Response responseBean = new Response();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);

		} finally {
			/* closing session */
			if (session != null) {
				session.close();
			}
		}
		return null;

	}

}
