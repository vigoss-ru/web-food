package com.pfrig.web.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pfrig.web.shop.dto.MenuDTO;
import com.pfrig.web.shop.dto.SubMenuDTO;
import com.pfrig.web.shop.util.ShopCartProvider;

public class MenuController {

	@Autowired
	private ShopCartProvider shopCartProvider;
	
	@RequestMapping(value = "/submenu", method = RequestMethod.GET)
	public String getSubMenu(HttpServletRequest request, ModelMap model){
		String item_nr = (String)request.getParameter("item_nr");
		MenuDTO menu = shopCartProvider.selectOneMenu(item_nr);
		model.addAttribute("menu", menu);
		
		List<SubMenuDTO> subMenus = shopCartProvider.selectSubMenu(item_nr);
		
		model.addAttribute("subMenus",subMenus);
		
		return "catalog/submenu";
	}
}
