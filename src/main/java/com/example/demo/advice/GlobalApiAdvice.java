package com.example.demo.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.models.FieldErrorModel;

@ControllerAdvice
public class GlobalApiAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<FieldError> errorList= exception.getBindingResult().getFieldErrors();
		List<FieldErrorModel> fieldErrorModel=new ArrayList<>();
		for(FieldError error:errorList){
			FieldErrorModel fem=new FieldErrorModel();
			fem.setErrorInput(error.getField());
			fem.setErrorMessage(error.getDefaultMessage());
			fieldErrorModel.add(fem);
		}
		
		return new ResponseEntity<>(fieldErrorModel,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<?> methodArgumentNotValidException(StudentNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
