package com.vic.common;

import java.util.Date;


public class CommonEntity {

	private String id;
	private Date   dtCreated;
	private Date   dtUpdated;
	private Date   dtDeleted;
	private String dataspace;
	private String lastUser;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDtCreated() {
		return dtCreated;
	}
	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
	}
	public Date getDtUpdated() {
		return dtUpdated;
	}
	public void setDtUpdated(Date dtUpdated) {
		this.dtUpdated = dtUpdated;
	}
	public Date getDtDeleted() {
		return dtDeleted;
	}
	public void setDtDeleted(Date dtDeleted) {
		this.dtDeleted = dtDeleted;
	}
	public String getDataspace() {
		return dataspace;
	}
	public void setDataspace(String dataspace) {
		this.dataspace = dataspace;
	}
	public String getLastUser() {
		return lastUser;
	}
	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}
}
