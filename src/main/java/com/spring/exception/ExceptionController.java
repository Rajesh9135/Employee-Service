package com.spring.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.spring.response.Response;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = AppException.class)
	public ResponseEntity<Response> appExceptionHandler(AppException e, WebRequest w) {
		HttpStatus status = HttpStatusCode.getHttpStatusByCode(Integer.valueOf(e.getStatusCode()));
		Response response = Response.builder().statusCode(e.getStatusCode()).statusMessage(e.getStatusMessage())
				.build();
		return ResponseEntity.status(status).body(response);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	protected ResponseEntity<Response> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			WebRequest request) {
		Response response = Response.builder().statusCode(400).statusMessage(ex.getBindingResult().getFieldErrors()
				.stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(", "))).build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	protected ResponseEntity<Response> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		Response response = Response.builder().statusCode(400).statusMessage(ex.getConstraintViolations().stream()
				.map(violation -> violation.getMessage()).collect(Collectors.joining(", "))).build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(Exception.class)
//    public ResponseEntity<Response> handleException(Exception ex) {
//        ex.printStackTrace();
//        Response response = new Response(AppConstant.INTERNAL_SERVER_ERROR, "Internal server error");
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
