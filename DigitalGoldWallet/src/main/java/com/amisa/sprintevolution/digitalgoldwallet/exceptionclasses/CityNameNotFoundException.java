package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class CityNameNotFoundException extends RuntimeException{
	public CityNameNotFoundException(String message){
		super(message);
	}
	public CityNameNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public CityNameNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
