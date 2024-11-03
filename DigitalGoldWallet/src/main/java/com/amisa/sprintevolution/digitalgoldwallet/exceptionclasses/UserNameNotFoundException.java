package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class UserNameNotFoundException extends RuntimeException {
	public UserNameNotFoundException(String message){
		super(message);
	}
	public UserNameNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public UserNameNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}

}