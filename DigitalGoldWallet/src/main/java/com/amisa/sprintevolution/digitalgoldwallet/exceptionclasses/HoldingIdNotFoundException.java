package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class HoldingIdNotFoundException extends RuntimeException{
	public HoldingIdNotFoundException(String message){
		super(message);
	}
	public HoldingIdNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public HoldingIdNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}