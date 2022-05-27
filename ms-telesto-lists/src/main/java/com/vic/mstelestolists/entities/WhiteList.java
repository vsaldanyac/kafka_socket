package com.vic.mstelestolists.entities;

import com.vic.common.CommonEntity;

import java.util.stream.Stream;


public class WhiteList extends CommonEntity {

	private String         code;
	private String         description;
	private Boolean        enabled;
	private Stream<String> zones;
	private Integer maxTime;
	private Stream<String> plates;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Stream<String> getZones() {
		return zones;
	}
	public void setZones(Stream<String> zones) {
		this.zones = zones;
	}
	public Integer getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(Integer maxTime) {
		this.maxTime = maxTime;
	}
	public Stream<String> getPlates() {
		return plates;
	}
	public void setPlates(Stream<String> plates) {
		this.plates = plates;
	}
}
