package com.pfrig.web.shop.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

public class SpringPropertiesUtil extends PropertyPlaceholderConfigurer {

	  private Map<String, String> propertiesMap;
	  // Default as in PropertyPlaceholderConfigurer
	  private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;
	
	  private String filenames = "";
	
	
	 public SpringPropertiesUtil() {
		 setFileEncoding("UTF-8");
	 }
	 
	 @Override
	    public void setLocation(Resource location) {
	        super.setLocation(location);
	        filenames = location.getFilename();
	    }

	    @Override
	    public void setLocations(Resource[] locations) {
	        super.setLocations(locations);
	        for (Resource resource : locations) {
	            filenames += resource.getDescription() + ", ";
	        }
	    }

	    @Override
	    public void setSystemPropertiesMode(int systemPropertiesMode) {
	        super.setSystemPropertiesMode(systemPropertiesMode);
	        springSystemPropertiesMode = systemPropertiesMode;
	    }

	    @Override
	    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
	            throws BeansException {
	        super.processProperties(beanFactory, props);

	        propertiesMap = new HashMap<String, String>();
	        for (Object key : props.keySet()) {
	            String keyStr = key.toString();
	            String valueStr = resolvePlaceholder(keyStr, props, springSystemPropertiesMode);
	            propertiesMap.put(keyStr, valueStr);
	        }

	        logger.info("Resolved properties from " + filenames + " are: " + props);
	    }
	    
	    public String getProperty(String name) {
	        return propertiesMap.get(name);
	    }
	    
	    public String getValue(String key) {
	        String value = (String) getProperty(key);
	        // logger.trace("getValue:  " + key + ": " + value);
	        return value;
	    }
}
