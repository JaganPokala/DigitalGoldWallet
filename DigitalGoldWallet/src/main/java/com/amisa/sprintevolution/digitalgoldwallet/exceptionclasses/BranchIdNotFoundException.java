package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class BranchIdNotFoundException extends RuntimeException{
	public BranchIdNotFoundException(String message){
		super(message);
	}
	public BranchIdNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public BranchIdNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}