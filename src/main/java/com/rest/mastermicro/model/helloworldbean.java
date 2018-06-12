package com.rest.mastermicro.model;

public class helloworldbean {

	private String message;
	
	public helloworldbean(String message) {
		this.message = message; 
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "helloworldbean [message=" + message + "]";
	}
	
}
