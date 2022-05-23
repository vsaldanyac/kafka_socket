package com.vic.driver.entities;

import com.vic.common.CommonEntity;


public class Brand extends CommonEntity {

	private int                        code;
	private String                     description;


	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
