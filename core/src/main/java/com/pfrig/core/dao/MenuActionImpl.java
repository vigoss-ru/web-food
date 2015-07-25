package com.pfrig.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;




import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pfrig.core.connection.DBConnection;
import com.pfrig.core.dto.MenuDTO;
import com.pfrig.core.dto.SubMenuDTO;

public class MenuActionImpl implements MenuAction{

	
	private DBConnection conn = new DBConnection();
	@Override
	public List<MenuDTO> selectMainMenu() {
		// TODO Auto-generated method stub
	
		JdbcTemplate template = conn.getInstance();
		String sqlStr = "select m.id, m.item_nr, m.name, m.german_text, m.english_text, m.price, m.image_link,"
						+ " (select count(*) from submenu where item_nr = m.item_nr) as sub_number from menu m";
		List<MenuDTO> rows = template.query(sqlStr,
							new RowMapper<MenuDTO>() {
								@Override
								public MenuDTO mapRow(ResultSet rs, int rowNum)
										throws SQLException {
									// TODO Auto-generated method stub
									MenuDTO menuDTO = new MenuDTO();
									menuDTO.setId(rs.getInt("id"));
									menuDTO.setItem_nr(rs.getString("item_nr"));
									menuDTO.setName(rs.getString("name"));
									menuDTO.setGerman_text(rs.getString("german_text"));
									menuDTO.setEnglish_text(rs.getString("english_text"));
									menuDTO.setPrice(rs.getBigDecimal("price"));
									menuDTO.setImage_link(rs.getString("image_link"));
									menuDTO.setSub_number(rs.getInt("sub_number"));
									return menuDTO;
								}
							});
		
		return rows;
	}
	
	
	@Override
	public MenuDTO selectOneMenu(String item_nr) {
		// TODO Auto-generated method stub
		JdbcTemplate template = conn.getInstance();
		String sqlStr =  "select m.id, m.item_nr, m.name, m.german_text, m.english_text, m.price"
							+", m.image_link from menu m where m.item_nr like '"+item_nr+"'";
		List<MenuDTO> rows = template.query(sqlStr,
				new RowMapper<MenuDTO>() {
					@Override
					public MenuDTO mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						// TODO Auto-generated method stub
						MenuDTO menuDTO = new MenuDTO();
						menuDTO.setId(rs.getInt("id"));
						menuDTO.setItem_nr(rs.getString("item_nr"));
						menuDTO.setName(rs.getString("name"));
						menuDTO.setGerman_text(rs.getString("german_text"));
						menuDTO.setEnglish_text(rs.getString("english_text"));
						menuDTO.setPrice(rs.getBigDecimal("price"));
						menuDTO.setImage_link(rs.getString("image_link"));
						return menuDTO;
					}
				});

		return rows.get(0);
	}


	@Override
	public List<SubMenuDTO> selectSubMenu(String item_nr) {
		// TODO Auto-generated method stub
		JdbcTemplate template = conn.getInstance();
		String sqlStr =  "select sm.id, sm.name, sm.detail, sm.price"
							+", sm.item_nr from submenu sm where sm.item_nr like '"+item_nr+"'";
		
		List<SubMenuDTO> rows = template.query(sqlStr,
			new RowMapper<SubMenuDTO>() {
				@Override
				public SubMenuDTO mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					// TODO Auto-generated method stub
					SubMenuDTO subDTO = new SubMenuDTO();
					subDTO.setId(rs.getInt("id"));
					subDTO.setName(rs.getString("name"));
					subDTO.setDetail(rs.getString("detail"));
					subDTO.setPrice(rs.getBigDecimal("price"));
					subDTO.setItem_nr(rs.getString("item_nr"));
					return subDTO;
				}
		});
		
		return rows;
	}

}
