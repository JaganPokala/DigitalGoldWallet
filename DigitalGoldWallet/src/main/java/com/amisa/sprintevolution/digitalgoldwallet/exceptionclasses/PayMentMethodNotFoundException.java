package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class PayMentMethodNotFoundException extends RuntimeException{
	public PayMentMethodNotFoundException(String message){
		super(message);
	}
	public PayMentMethodNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public PayMentMethodNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}