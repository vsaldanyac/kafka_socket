package com.vic.driver.entities;

import com.vic.common.CommonEntity;
import com.vic.driver.entities.enums.Status;

import javax.print.attribute.standard.Severity;
import javax.xml.stream.Location;
import java.util.Map;


public class Camera extends CommonEntity {

	private int                        code;
	private String                     description;
	private Location                   location;
	private Brand                      brand;
	private String                     ip;
	private int                        port;
	private String                     serialNumber;
	private String                     picture1;
	private String                     picture2;
	private Status                     status;
	private Severity                   activeAlarmsSeverity;
	private Map<DetailAlarm, Severity> activeAlarms;


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
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Severity getActiveAlarmsSeverity() {
		return activeAlarmsSeverity;
	}
	public void setActiveAlarmsSeverity(Severity activeAlarmsSeverity) {
		this.activeAlarmsSeverity = activeAlarmsSeverity;
	}
	public Map<DetailAlarm, Severity> getActiveAlarms() {
		return activeAlarms;
	}
	public void setActiveAlarms(Map<DetailAlarm, Severity> activeAlarms) {
		this.activeAlarms = activeAlarms;
	}
}
