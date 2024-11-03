package com.amisa.sprintevolution.digitalgoldwallet.GlobelHandlers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.*;

@ControllerAdvice
public class DigiGoldExceptionHandler {

	  @ExceptionHandler(UserIdNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(UserIdNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  
	  
	  @ExceptionHandler(AddressIdNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(AddressIdNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  
	  @ExceptionHandler(UserNameNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(UserNameNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  
	  @ExceptionHandler(CityNameNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(CityNameNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  
	  @ExceptionHandler(StateNameNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(StateNameNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(BranchIdNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(BranchIdNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  @ExceptionHandler(CountryNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(CountryNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(HoldingIdNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(HoldingIdNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(PaymentIdNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(PaymentIdNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(PayMentMethodNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(PayMentMethodNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(TransactionHistoryNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(TransactionHistoryNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(TransactionIdNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(TransactionIdNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(TransactionTypeNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(TransactionTypeNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(VendorIdNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(VendorIdNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler(VendorNameNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleException(VendorNameNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
	  
	  @ExceptionHandler
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ResponseEntity<ErrorResponse> handleAllExceptions(Exception genericException) {
			ErrorResponse error = new ErrorResponse();
			error.setMessage(genericException.getMessage());
			error.setTimeStamp(LocalDate.now());
	 
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	  
	 
	
}
