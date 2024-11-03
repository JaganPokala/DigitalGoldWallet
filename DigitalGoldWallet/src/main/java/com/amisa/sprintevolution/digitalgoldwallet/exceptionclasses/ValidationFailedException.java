package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class ValidationFailedException extends RuntimeException {
	public ValidationFailedException(String message){
		super(message);
	}
	public ValidationFailedException(String message,Throwable e){
		super(message,e);
	}
	public ValidationFailedException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
