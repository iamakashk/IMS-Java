package com.ims;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.helper.HibernateUtil;
import com.ims.helper.RandomNumberGenerator;
import com.ims.helper.ResourceReaderUtil;
import com.ims.helper.ServiceStop;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
public class InventorySystemApplication {
	private static final Logger LOG = LogManager.getFormatterLogger();

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		/* returning object of RestTemplate */
		return new RestTemplate();
	}

	/**
	 * Main Method
	 */
	public static void main(String[] args) {

		/* APPLICATION START-UP */

		String logID = RandomNumberGenerator.generateRandomNumberForLOG();
		long startTime = System.currentTimeMillis();

		/* declaring objects */
		SpringApplication application = null;
		Properties props = null;
		ConfigurableApplicationContext applicationContext = null;
		try {
			/* ============= BUSINESS LOGIC ================= */

			System.setProperty("spring.devtools.restart.enabled", "false");

			/* defining application class */
			application = new SpringApplication( InventorySystemApplication.class);

			/* reading application properties */
			props = ResourceReaderUtil.fetchProperties(ResourceReaderUtil.PROPERTY_FILE, logID);

			if (props != null) {

				Map<String, Object> appProperties = setApplicationConstant(props);


				/* setting properties into application */
				application.setDefaultProperties(appProperties);


				/*-----RUN APPLICATION-------------*/
				applicationContext=application.run(args); // ConfigurableApplicationContext
				
				LOG.info(CommonConstants.strGalaxy);
				LOG.info(logID +MessageConstants.REDIS_CONFIGURATION_START_MSG);
				boolean redisStarted = false;
				int RedisPortNo = CommonConstants.CACHE_SERVER_PORT_NO;// 6380
				String cacheServerIP=CommonConstants.CACHE_SERVER_IP;
				redisStarted = isRedisServerUp(RedisPortNo, cacheServerIP,logID);
				LOG.info(logID +MessageConstants.REDIS_CONFIGURATION_END_MSG);
				
				if (redisStarted) {
					createSessionOfDatabase(logID);
				}
				else
				{
					LOG.info(logID +MessageConstants.QUITING_SERVICE_MSG);
					//SpringApplication.exit(applicationContext,  new ServiceStop());	
				}
			} 
		} catch (Exception e) {
			LOG.error(logID + MessageConstants.LOGGER_ERROR_MESSAGE);
			LOG.error(logID + e);
			LOG.info(logID + MessageConstants.LOGGER_APP_BAR);
		}

		/* timer variable */
		long endTime = System.currentTimeMillis();
		LOG.info(logID + MessageConstants.EXEC_TIME + (endTime - startTime));
		LOG.info(logID + MessageConstants.LOGGER_APP_BAR);

	}

	/**
	 * This method is used to set application constant.
	 * 
	 * @param props
	 * @return map
	 */
	public static Map<String, Object> setApplicationConstant(Properties props) {
		Map<String, Object> appProperties = new HashMap<String, Object>();
		if (props != null) {
		String p_AttributeKey = CommonConstants.BLANK;
		String p_AttributeValue = CommonConstants.BLANK;
		Enumeration<Object> enuKeys = props.keys();
	
			/* iterating through enum */
			while (enuKeys.hasMoreElements()) {
				/* get Key */
				p_AttributeKey = (String) enuKeys.nextElement();
				/* get Value */
				p_AttributeValue = props.getProperty(p_AttributeKey);
				/* adding properties in main map */
				appProperties.put(p_AttributeKey, p_AttributeValue);

				if (p_AttributeKey.equals(CommonConstants.CACHE_SERVER_PORT)) {
					CommonConstants.CACHE_SERVER_PORT_NO = Integer.parseInt(p_AttributeValue);
				}
				if (p_AttributeKey.equals(CommonConstants.CACHE_SERVER_IP)) {
					CommonConstants.CACHE_SERVER_IP = p_AttributeValue;
				}
			}
			enuKeys = null;
		}
		return appProperties;
	}

	/**
	 * This method is used to check redis server is up and running.
	 * 
	 * @param portNumber
	 * @return true if up and running else return false.
	 */
	public static boolean isRedisServerUp(int portNumber, String serverIP, String logID) {

		LOG.info(logID+MessageConstants.REDIS_SERVER_UP_OR_DOWN_MSG+ portNumber);
		JedisPool pool = null;
		Jedis jedis = null;
		boolean isRedisUP = false;
		try {
			pool = new JedisPool(new JedisPoolConfig(), serverIP, portNumber);
			jedis = pool.getResource();
			LOG.info(logID + MessageConstants.REDIS_SERVER_UP_MSG + portNumber);
			isRedisUP = true;
		} catch (Exception exception) {
			isRedisUP = false;
			LOG.info(logID + MessageConstants.REDIS_SERVER_DOWN_MSG);
			LOG.error(logID + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logID + exception);
			LOG.error(logID + CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (pool != null) {
				pool.close();
			}
			if (jedis != null) {
				jedis = null;
			}
		}
		return isRedisUP;
	}

	/**
	 * This method is used to create session of database.
	 */
	public static void createSessionOfDatabase(String logId) {
		Session session = null;
		try {
			LOG.info(logId + MessageConstants.GETTING_SESSION_DB_MSG);
			session = HibernateUtil.getSessionFactory(logId).openSession();
			LOG.info(logId + MessageConstants.SESSION_CREATED_MSG);
		} catch (Exception e) {
			LOG.info(logId +MessageConstants.SESSION_NOT_CREATED_MSG);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId, e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (session != null)
				session.close();
		}
	}

}
