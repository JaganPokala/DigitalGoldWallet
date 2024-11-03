package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
public class PaymentIdNotFoundException extends RuntimeException{
		public PaymentIdNotFoundException(String message){
			super(message);
		}
		public PaymentIdNotFoundException(String message,Throwable e){
			super(message,e);
		}
		public PaymentIdNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
			super(message,e,enablesuppression,enablestacktrace);
		}
	}