package com.pfrig.core.dao;

import java.util.List;




import com.pfrig.core.dto.MenuDTO;
import com.pfrig.core.dto.SubMenuDTO;

public interface MenuAction {

	List<MenuDTO> selectMainMenu();
	
	MenuDTO selectOneMenu(String item_nr);
	
	List<SubMenuDTO> selectSubMenu(String item_nr);
}
