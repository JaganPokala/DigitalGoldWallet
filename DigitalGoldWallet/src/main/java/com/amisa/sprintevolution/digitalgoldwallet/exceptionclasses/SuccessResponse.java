package com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses;
import java.time.LocalDate;
 
public class SuccessResponse {
  private LocalDate timeStamp;
  private String message;
public SuccessResponse(LocalDate timeStamp, String message) {
	super();
	this.timeStamp = timeStamp;
	this.message = message;
}
public SuccessResponse() {
	super();
}
public LocalDate getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDate timeStamp) {
	this.timeStamp = timeStamp;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}