package com.pfrig.web.shop.dto;

import java.util.ArrayList;
import java.util.List;

public class MenuDTOUtil {
	
	
	public static List<MenuDTO> transferListMainMenu(List<com.pfrig.core.dto.MenuDTO> source ){
		List<MenuDTO> lists = new ArrayList<MenuDTO>();
		for (com.pfrig.core.dto.MenuDTO menuDTO : source) {
			MenuDTO menuDTOTarge = new MenuDTO();
			transferMainMenu(menuDTO, menuDTOTarge);
			lists.add(menuDTOTarge);
		}
		return lists;
	}
	
	
	public static void transferMainMenu (com.pfrig.core.dto.MenuDTO source, MenuDTO target) {
		target.setId(source.getId());
		target.setItem_nr(source.getItem_nr());
		target.setName(source.getName());
		target.setGerman_text(source.getGerman_text());
		target.setEnglish_text(source.getEnglish_text());
		target.setPrice(source.getPrice());
		target.setImage_link(source.getImage_link());
		target.setSub_number(source.getSub_number());
	}
	
	public static List<SubMenuDTO> transferListSubMenu(List<com.pfrig.core.dto.SubMenuDTO> source ){
		List<SubMenuDTO> lists = new ArrayList<SubMenuDTO>();
		for (com.pfrig.core.dto.SubMenuDTO menuDTO : source) {
			SubMenuDTO menuDTOTarge = new SubMenuDTO();
			transferSubMenu(menuDTO, menuDTOTarge);
			lists.add(menuDTOTarge);
		}
		return lists;
	}
	
	
	public static void transferSubMenu (com.pfrig.core.dto.SubMenuDTO source, SubMenuDTO target) {
		target.setId(source.getId());
		target.setItem_nr(source.getItem_nr());
		target.setName(source.getName());
		target.setPrice(source.getPrice());
		target.setDetail(source.getDetail());
	}

}
