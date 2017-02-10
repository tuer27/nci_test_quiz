package com.nciinc.ws.endpoint;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BusinessException(){
	}
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(Throwable th) {
		super(th);
	}
	
	public BusinessException(String message,Throwable th) {
		super(message,th);
	}

}
