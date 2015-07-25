package com.pfrig.web.shop.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MenuDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String item_nr;
	
	private String name;
	
	private String german_text;
	
	private String english_text;
	
	private BigDecimal price;
	
	private String image_link;
	
	private int sub_number;
	
	public String getItem_nr() {
		return item_nr;
	}
	
	public void setItem_nr(String item_nr) {
		this.item_nr = item_nr;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGerman_text() {
		return german_text;
	}
	
	public void setGerman_text(String german_text) {
		this.german_text = german_text;
	}
	
	public String getEnglish_text() {
		return english_text;
	}
	
	public void setEnglish_text(String english_text) {
		this.english_text = english_text;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getImage_link() {
		return image_link;
	}
	
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSub_number() {
		return sub_number;
	}

	public void setSub_number(int sub_number) {
		this.sub_number = sub_number;
	}
}
