package com.cg.fms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> handleExceptions( CourseNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
		return entity;
	}
	
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<Object> handleExceptions( FeedbackNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
		return entity;
	}
	
	@ExceptionHandler(IncorrectNameAndRoleException.class)
	public ResponseEntity<Object> handleExceptions( IncorrectNameAndRoleException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); 
		return entity;
	}
	
	@ExceptionHandler(InvalidNumberLimitException.class)
	public ResponseEntity<Object> handleExceptions( InvalidNumberLimitException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); 
		return entity;
	}
	
	@ExceptionHandler(ProgramNotFoundException.class)
	public ResponseEntity<Object> handleExceptions( ProgramNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
		return entity;
	}
	
	@ExceptionHandler(TrainerNotFoundException.class)
	public ResponseEntity<Object> handleExceptions( TrainerNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
		return entity;
	}

}
