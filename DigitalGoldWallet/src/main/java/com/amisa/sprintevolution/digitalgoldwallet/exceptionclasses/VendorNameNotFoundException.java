package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class VendorNameNotFoundException extends RuntimeException{
	public VendorNameNotFoundException(String message){
		super(message);
	}
	public VendorNameNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public VendorNameNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}