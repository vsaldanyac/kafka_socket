package com.vic.mstelestolists.entities;

import com.vic.common.CommonEntity;

import java.util.stream.Stream;


public class BlackList extends CommonEntity {

	private String         code;
	private String         description;
	private Boolean        enabled;
	private Stream<String> zones;
	private Boolean acousticSignal;
	private Stream<String> plates;
	private Stream<String> mails;

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
	public Boolean getAcousticSignal() {
		return acousticSignal;
	}
	public void setAcousticSignal(Boolean acousticSignal) {
		this.acousticSignal = acousticSignal;
	}
	public Stream<String> getPlates() {
		return plates;
	}
	public void setPlates(Stream<String> plates) {
		this.plates = plates;
	}
	public Stream<String> getMails() {
		return mails;
	}
	public void setMails(Stream<String> mails) {
		this.mails = mails;
	}
}
