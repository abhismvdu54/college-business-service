package com.cd.college.exception;

@SuppressWarnings("serial")
public class CollegeBusinessServiceException extends BaseBusinessServiceException{

	public CollegeBusinessServiceException(int applicationCode, int code, int status, String exceptionMessage) {
		super(applicationCode, code, status, exceptionMessage);
	}
	public CollegeBusinessServiceException(int applicationCode, int code, int status, String exceptionMessage, Throwable t) {
		super(applicationCode, code, status, exceptionMessage, t);
	}
}
