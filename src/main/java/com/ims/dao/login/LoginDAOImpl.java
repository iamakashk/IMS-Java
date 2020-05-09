package com.ims.dao.login;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ims.beans.Response;
import com.ims.beans.UserDetails;
import com.ims.beans.login.Users;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.HibernateUtil;

@Repository
public class LoginDAOImpl implements LoginDAO {
	private static final Logger LOG = LogManager.getFormatterLogger();

	@Override
	public UserDetails validateUserDAO(String logId, String userId, String password) {
		LOG.info(" >>>>>>>>>>>>GETTING DETAILS FOR ID & PASSWORD >>>>>>>>>"+ userId + ">>>>>>>> "+ password );
		Session session = null;
		Criteria cr = null;
		UserDetails userDetails = new UserDetails();
		Users users = new Users();
		Response responseBean = new Response();
		try {
			session = HibernateUtil.getSessionFactory(logId).openSession();
			users = session.get(Users.class, userId);
			if(users == null || users.equals("")) {
				userDetails.setUser(users);
				responseBean.setRespCode(CommonConstants.FAILURE_CODE);
				responseBean.setRespMsg(MessageConstants.LOGIN_ERROR);
				userDetails.setResponseBean(responseBean);
			}else
			if(StringUtils.equals(users.getUSR_PASSWORD().toString(), password.trim())) {
				userDetails.setUser(users);
				responseBean.setRespCode(CommonConstants.SUCCESSS_CODE);
				responseBean.setRespMsg(MessageConstants.LOGIN_SUCCESS);
				userDetails.setResponseBean(responseBean);
			}else {
				userDetails.setUser(users);
				responseBean.setRespCode(CommonConstants.FAILURE_CODE);
				responseBean.setRespMsg(MessageConstants.LOGIN_ERROR);
				userDetails.setResponseBean(responseBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);

		} finally {
			cr = null;
			/* closing session */
			if (session != null) {
				session.close();
			}
		}

		return userDetails;
	}

}
