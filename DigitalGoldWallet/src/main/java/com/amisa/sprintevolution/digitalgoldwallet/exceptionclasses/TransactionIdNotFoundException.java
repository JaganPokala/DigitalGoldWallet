package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class TransactionIdNotFoundException extends RuntimeException {
	
	public TransactionIdNotFoundException(String message){
		super(message);
	}
	public TransactionIdNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public TransactionIdNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
