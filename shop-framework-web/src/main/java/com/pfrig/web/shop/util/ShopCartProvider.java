package com.pfrig.web.shop.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pfrig.core.dao.MenuAction;
import com.pfrig.core.dao.MenuActionImpl;
import com.pfrig.web.shop.dto.SubMenuDTO;
import com.pfrig.web.shop.dto.MenuDTO;
import com.pfrig.web.shop.dto.MenuDTOUtil;

@Controller
@Scope("session")
public class ShopCartProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<MenuDTO> mainMenu;
	
	
	public  List<MenuDTO> getListMainMenu() {
		if(mainMenu == null){
			MenuAction menu = new MenuActionImpl();
			List<com.pfrig.core.dto.MenuDTO> rows = menu.selectMainMenu();
			mainMenu = MenuDTOUtil.transferListMainMenu(rows);
			return mainMenu;
		}
		return mainMenu;
	}
	
	public MenuDTO selectOneMenu(String item_nr) {
		MenuAction menu = new MenuActionImpl();
		com.pfrig.core.dto.MenuDTO row = menu.selectOneMenu(item_nr);
		MenuDTO singleMenu = new MenuDTO();
		MenuDTOUtil.transferMainMenu(row, singleMenu);
		return singleMenu;
	}
	
	public List<SubMenuDTO> selectSubMenu(String item_nr) {
		MenuAction menu = new MenuActionImpl();
		List<com.pfrig.core.dto.SubMenuDTO> rows = menu.selectSubMenu(item_nr);
		List<SubMenuDTO> subMenus = MenuDTOUtil.transferListSubMenu(rows);
		return subMenus;
	}
	
}
