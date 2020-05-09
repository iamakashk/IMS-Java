package com.ims.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ims.beans.City;
import com.ims.beans.CustomerSupplier;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Response;
import com.ims.beans.State;
import com.ims.beans.UserDetails;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.HibernateUtil;
import com.ims.helper.RandomNumberGenerator;

@RestController
public class StateCityController {
	private static final Logger LOG = LogManager.getFormatterLogger();

	@RequestMapping(path=RestMappingProvider.USER_STATES , method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public FinalResponseBean<State> getAllStates(String logId) {
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<State> finalResponseBean = new FinalResponseBean<State>();
		List<State> stateList = new ArrayList<State>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			
			Query query = session.createQuery(" from State");
			LOG.info("query.list() >>>>>>>>>>>>> "+ query.list());
			State states = new State();
			states =(State) query.list().get(0);
			String queryStr  = new Gson().toJson(states, State.class);
			LOG.info("query.list() >>>>>>>>>>>>> "+ queryStr);
			stateList = (List<State>) query.list();
			finalResponseBean.setData(stateList);
			
			
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

	
	@RequestMapping(path=RestMappingProvider.USER_CITY_USING_STATE, method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public FinalResponseBean<City> getCityByState(@PathVariable("stateId") String stateId) {
		String logId = "";
		Session session = null;
		Response responseBean = new Response();
		FinalResponseBean<City> finalResponseBean = new FinalResponseBean<City>();
		List<City> stateList = new ArrayList<City>();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			session.beginTransaction();
			responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
			responseBean.setRespMsg(MessageConstants.ITEMS_ITEM_ADD_SUCCESS);
			
			
			Criteria criteria = session.createCriteria(City.class);
			criteria.add(Restrictions.eq("stateId", Integer.valueOf(stateId)));
			LOG.info("query.list() >>>>>>>>>>>>> "+ criteria.list());
			stateList = (List<City>) criteria.list();
			finalResponseBean.setData(stateList);
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
