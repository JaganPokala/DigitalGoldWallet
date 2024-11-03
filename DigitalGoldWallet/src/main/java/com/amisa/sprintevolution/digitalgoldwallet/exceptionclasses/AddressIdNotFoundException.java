package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class AddressIdNotFoundException extends RuntimeException{
	public AddressIdNotFoundException(String message){
		super(message);
	}
	public AddressIdNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public AddressIdNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}