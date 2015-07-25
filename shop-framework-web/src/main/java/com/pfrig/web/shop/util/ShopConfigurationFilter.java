package com.pfrig.web.shop.util;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component("shopConfigurationFilter")
public class ShopConfigurationFilter implements Filter {

	@Resource(name = "shopPropertiesHolder")
	private SpringPropertiesUtil shopProperties;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        setSessionValues(httpRequest);
        chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	private void setSessionValues(HttpServletRequest request) {
		setSessionAttribute(request, ShopProperties.STATIC_CSS_ROOT_PATH);
		setSessionAttribute(request, ShopProperties.STATIC_JS_ROOT_PATH);
		setSessionAttribute(request, ShopProperties.STATIC_IMAGE_ROOT_PATH);
	}
	
	 private void setSessionAttribute(HttpServletRequest request, String attributekey) {
		 request.getSession().setAttribute(attributekey, shopProperties.getValue(attributekey));
	 }
}
