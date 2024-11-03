package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;

public class NoListFoundException extends RuntimeException {
	
	public NoListFoundException(String message){
		super(message);
	}
	public NoListFoundException(String message,Throwable e){
		super(message,e);
	}
	public NoListFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}

}
