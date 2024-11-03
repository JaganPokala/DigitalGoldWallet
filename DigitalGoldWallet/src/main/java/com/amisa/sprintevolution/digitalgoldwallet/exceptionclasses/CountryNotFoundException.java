package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class CountryNotFoundException extends RuntimeException{
	public CountryNotFoundException(String message){
		super(message);
	}
	public CountryNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public CountryNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}