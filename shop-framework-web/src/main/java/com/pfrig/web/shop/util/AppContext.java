package com.pfrig.web.shop.util;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;




import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AppContext implements ServletContextListener {

	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		try{
			Enumeration<Driver> drivers = DriverManager.getDrivers();
	        while(drivers.hasMoreElements()) {
	            DriverManager.deregisterDriver(drivers.nextElement());
	        }
		}catch(Exception e){
			logger.error(e);
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
