package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class VendorIdNotFoundException extends RuntimeException{
	public VendorIdNotFoundException(String message){
		super(message);
	}
	public VendorIdNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public VendorIdNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}