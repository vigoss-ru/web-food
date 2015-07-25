package com.pfrig.core.connection;



import javax.sql.DataSource;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class DBConnection {
	
	
	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private static volatile JdbcTemplate instance = null;
	
	public JdbcTemplate getInstance(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/db-config.xml");
		DataSource dataSource = ctx.getBean(DataSource.class);
		setDataSource(dataSource);
		if(instance==null){
			instance = new JdbcTemplate(getDataSource());
		}
		
		return instance;
	}

}
