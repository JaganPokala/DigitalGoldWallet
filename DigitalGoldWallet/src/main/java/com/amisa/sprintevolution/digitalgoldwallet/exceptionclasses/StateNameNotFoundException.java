package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;

public class StateNameNotFoundException extends RuntimeException{
	
	public StateNameNotFoundException(String message){
		super(message);
	}
	public StateNameNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public StateNameNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
