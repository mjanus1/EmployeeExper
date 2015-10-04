package com.mariusz.empexp.core.exception;

public class ServiceException extends Exception implements IError{

	private static final long serialVersionUID = 1L;

	private final String errorCode;
	
	public ServiceException(String errorCode) {
		super();
		this.errorCode=errorCode;
	}



	public ServiceException(String arg0, Throwable arg1,String errorCode) {
		super(arg0, arg1);
		this.errorCode=errorCode;
	}



	public ServiceException(String arg0,String errorCode) {
		super(arg0);
		this.errorCode=errorCode;
	}



	public ServiceException(Throwable arg0,String errorCode) {
		super(arg0);
		this.errorCode=errorCode;
	}



	@Override
	public String getErrorCode() {
		
		return errorCode;
	}
	


}
