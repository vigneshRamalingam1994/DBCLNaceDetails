package com.nace.common.msgs;

public class BaseResponse {

	private String message;

	public BaseResponse(String message) {
		this.message = message;
	}

	BaseResponse() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
