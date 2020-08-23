package com.ssa.exception;

import java.util.Date;

public class ApiError {

	private Integer errorCode;
	private String erroeDes;
	private Date date;
	
	public ApiError() {
	}
	
	public ApiError(Integer errorCode, String erroeDes, Date date) {
		this.errorCode = errorCode;
		this.erroeDes = erroeDes;
		this.date = date;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErroeDes() {
		return erroeDes;
	}
	public void setErroeDes(String erroeDes) {
		this.erroeDes = erroeDes;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
}
