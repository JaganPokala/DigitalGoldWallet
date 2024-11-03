package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class TransactionHistoryNotFoundException extends RuntimeException {
	public TransactionHistoryNotFoundException(String message){
		super(message);
	}
	public TransactionHistoryNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public TransactionHistoryNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
