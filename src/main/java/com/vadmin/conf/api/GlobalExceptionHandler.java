package com.vadmin.conf.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private String internalServerError = "Ha sucedido un error en el proceso del servicio";
	
	   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
	   
		@ExceptionHandler(Exception.class)
		public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) throws Exception {
			 return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,exception.getLocalizedMessage(), internalServerError));
		}
	   
	   @ExceptionHandler(RuntimeException.class)
	   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	   public final ResponseEntity<Object> handleAllUncaughtException(RuntimeException exception, WebRequest request){
		   return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,exception.getLocalizedMessage(), internalServerError));
	   }

}