package com.ssa.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class AppExceptionHandler {
	
	
	@ExceptionHandler(value = NoSSNNumberFoundexception.class)
	public ResponseEntity<ApiError> NoSSNNumberFoundexception(){
		
		ApiError errorBody = new ApiError(400, " In-Valid SSN Number.", new Date());
		
		return new ResponseEntity<ApiError>(errorBody,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(value = SSNInformationNotFount.class)
	public ResponseEntity<ApiError> SSNInformationNotFount(){
		
		ApiError errorBody = new ApiError(400, "Enable to Process your Request..!.", new Date());
		
		return new ResponseEntity<ApiError>(errorBody,HttpStatus.BAD_REQUEST);
		
	}
	
}
