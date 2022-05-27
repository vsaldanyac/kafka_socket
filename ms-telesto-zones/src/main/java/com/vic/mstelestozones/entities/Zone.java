package com.vic.mstelestozones.entities;

import com.vic.common.CommonEntity;

import javax.xml.stream.Location;
import java.util.List;
import java.util.stream.Stream;


public class Zone extends CommonEntity {

	private String code;
	private String description;
	private Stream<String> type;
	private Stream<Location> geographicalPoints;
	private Stream<String> inCameras;
	private Stream<String> outCameras;


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
	public Stream<String> getType() {
		return type;
	}
	public void setType(Stream<String> type) {
		this.type = type;
	}
	public Stream<Location> getGeographicalPoints() {
		return geographicalPoints;
	}
	public void setGeographicalPoints(Stream<Location> geographicalPoints) {
		this.geographicalPoints = geographicalPoints;
	}
	public Stream<String> getInCameras() {
		return inCameras;
	}
	public void setInCameras(Stream<String> inCameras) {
		this.inCameras = inCameras;
	}
	public Stream<String> getOutCameras() {
		return outCameras;
	}
	public void setOutCameras(Stream<String> outCameras) {
		this.outCameras = outCameras;
	}
}
