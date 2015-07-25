package com.pfrig.web.shop.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pfrig.web.shop.dto.MenuDTO;
import com.pfrig.web.shop.util.ShopCartProvider;




public class WelcomeController {

	
	@Autowired
	private ShopCartProvider shopCartProvider;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, ModelMap model) {
		
		//List<MenuDTO> mainMenus =  shopCartProvider.getListMainMenu();
		//model.addAttribute("mainMenus",mainMenus);
		return "catalog/welcome";
	}
	
	
	

}
