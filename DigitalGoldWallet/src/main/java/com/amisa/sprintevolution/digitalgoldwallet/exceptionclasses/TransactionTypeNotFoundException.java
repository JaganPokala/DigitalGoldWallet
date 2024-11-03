package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class TransactionTypeNotFoundException extends RuntimeException{
	public TransactionTypeNotFoundException(String message){
		super(message);
	}
	public TransactionTypeNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public TransactionTypeNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}