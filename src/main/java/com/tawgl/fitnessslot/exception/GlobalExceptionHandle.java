package com.tawgl.fitnessslot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ExceptionMessage> handleIdNotFoundException(IdNotFoundException idNotFoundException,
			WebRequest request) {
		ExceptionMessage message = new ExceptionMessage(new Date(), idNotFoundException.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NewRecordCreationException.class)
	public ResponseEntity<ExceptionMessage> handleNewRecordCreationException(
			NewRecordCreationException newRecordCreationException, WebRequest request) {
		ExceptionMessage message = new ExceptionMessage(new Date(), newRecordCreationException.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(message, HttpStatus.BAD_GATEWAY);
	}

}
