package com.bernardspace.twitterfriends.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TwitterExceptionAspect {


	@ExceptionHandler
	public ResponseEntity<TwitterExceptionEntity> badrequestfortwitterHandler(Exception exc){
		TwitterExceptionEntity errorResponse = new TwitterExceptionEntity(HttpStatus.BAD_REQUEST.value(),
																exc.getMessage(),
																System.currentTimeMillis());
		return new ResponseEntity<> ( errorResponse, HttpStatus.BAD_REQUEST);
	}

}
