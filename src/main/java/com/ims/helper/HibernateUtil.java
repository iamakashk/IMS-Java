/**
 * 
 */
package com.ims.helper;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ims.beans.AreaLocation;
import com.ims.beans.City;
import com.ims.beans.CustomerAddress;
import com.ims.beans.CustomerSupplier;
import com.ims.beans.EnquiryDetails;
import com.ims.beans.EnquiryMaster;
import com.ims.beans.EnquiryMasterGet;
import com.ims.beans.Item;
import com.ims.beans.ItemGroup;
import com.ims.beans.ItemSubGroup;
import com.ims.beans.Source;
import com.ims.beans.State;
import com.ims.beans.login.Users;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;

public class HibernateUtil {

	private static final Logger LOG = LogManager.getFormatterLogger();
	public static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory(String logID) {
		LOG.info(logID + MessageConstants.GETTING_SESSION_DB_MSG);
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's
				// properties
				Properties settings = new Properties();

				String driverName = "com.mysql.cj.jdbc.Driver";
				
				  String dbUrl="jdbc:mysql://localhost:3306/INVENTORY_SYSTEM_DB";
				  String dbUserName="root"; 
				  String dbPassword="root";
				 
				
				/*
				 * String dbUrl = com.ims.configuration.Configuration
				 * .getParameter(com.ims.configuration.Configuration.DB_URL, logID); String
				 * dbUserName = com.ims.configuration.Configuration
				 * .getParameter(com.ims.configuration.Configuration.DB_USER_NAME, logID);
				 * String dbPassword = com.ims.configuration.Configuration
				 * .getParameter(com.ims.configuration.Configuration.DB_USER_PASSWORD, logID);
				 */

				LOG.info(logID + "Trying to connect db URL: " + dbUrl);

				settings.put(Environment.DRIVER, driverName);
				settings.put(Environment.URL, dbUrl + "?useSSL=false");
				settings.put(Environment.USER, dbUserName);
				settings.put(Environment.PASS, dbPassword);
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				/* settings.put(Environment.HBM2DDL_AUTO, "create-drop"); */

				settings.put(Environment.DEFAULT_BATCH_FETCH_SIZE, "20");
				configuration.setProperties(settings);

				/* <<ADD HIBERNATE ANNOTED CLASS>> */

				addAnnotatedClass(configuration);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(logID + "CONNECTION FAILURE");
				LOG.error(logID + CommonConstants.EXCEPTION_STRING_START);
				LOG.error(logID + e);
				LOG.error(logID + CommonConstants.EXCEPTION_STRING_END);
				sessionFactory = null;
			}
		}

		return sessionFactory;
	}

	public static boolean checkDBConnection(String logID, String dbUrl, String dbUserName, String dbPassword) {
		LOG.info(logID + "CONNECTING TO DB");
		boolean isConnected = false;
		SessionFactory session = null;
		try {
			Configuration configuration = new Configuration();
			Properties settings = new Properties();
			String driverName = "com.mysql.jdbc.Driver";

			/*
			 * String dbUrl =
			 * com.etp.galaxy.testService.configuration.Configuration
			 * .getParameter(com.etp.galaxy.testService.configuration.
			 * Configuration.DB_URL); String dbUserName =
			 * com.etp.galaxy.testService.configuration.Configuration
			 * .getParameter(com.etp.galaxy.testService.configuration.
			 * Configuration.DB_USER_NAME); String dbPassword =
			 * com.etp.galaxy.testService.configuration.Configuration
			 * .getParameter(com.etp.galaxy.testService.configuration.
			 * Configuration.DB_USER_PASSWORD);
			 */

			LOG.info(logID + "TRYING TO CONNECT DB URL: " + dbUrl);

			settings.put(Environment.DRIVER, driverName);
			settings.put(Environment.URL, dbUrl + "?useSSL=false");
			settings.put(Environment.USER, dbUserName);
			settings.put(Environment.PASS, dbPassword);
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			configuration.setProperties(settings);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			session = configuration.buildSessionFactory(serviceRegistry);
			isConnected = true;
			session.close();
			LOG.info(logID + "CONNECTION SUCCESS.");
		} catch (Exception e) {
			LOG.error(logID + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logID + "CONNECTION FAILURE.");
			LOG.error(logID + e);
			LOG.error(logID + CommonConstants.EXCEPTION_STRING_END);

		}
		return isConnected;
	}

	/**
	 * This method is used to add annotated classes.
	 * 
	 * @param configuration
	 */
	public static void addAnnotatedClass(Configuration configuration) {

		/*ADD CLASS*/
		configuration.addAnnotatedClass(Users.class);
		configuration.addAnnotatedClass(Item.class);
		configuration.addAnnotatedClass(ItemGroup.class);
		configuration.addAnnotatedClass(ItemSubGroup.class);
		configuration.addAnnotatedClass(CustomerSupplier.class);
		configuration.addAnnotatedClass(CustomerAddress.class);
		configuration.addAnnotatedClass(State.class);
		configuration.addAnnotatedClass(City.class);
		configuration.addAnnotatedClass(AreaLocation.class);
		configuration.addAnnotatedClass(Source.class);
		configuration.addAnnotatedClass(EnquiryMaster.class);
		configuration.addAnnotatedClass(EnquiryDetails.class);
		configuration.addAnnotatedClass(EnquiryMasterGet.class);


	}
}
