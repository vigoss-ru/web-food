package com.pfrig.core.dto;

import java.math.BigDecimal;

public class SubMenuDTO {

	private int id;
	
	private String name;
	
	private String detail;
	
	private BigDecimal price;
	
	private String item_nr;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getItem_nr() {
		return item_nr;
	}

	public void setItem_nr(String item_nr) {
		this.item_nr = item_nr;
	}
	
	
}
