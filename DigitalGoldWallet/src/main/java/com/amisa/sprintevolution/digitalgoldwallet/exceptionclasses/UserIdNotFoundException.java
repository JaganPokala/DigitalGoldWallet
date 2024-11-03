package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class UserIdNotFoundException extends RuntimeException{
	
	public UserIdNotFoundException(String message){
		super(message);
	}
	public UserIdNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public UserIdNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}

}
