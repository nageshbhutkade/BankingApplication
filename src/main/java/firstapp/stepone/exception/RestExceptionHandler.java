package firstapp.stepone.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity<ApiError> handleAccountNotFoundException(AccountNotFoundException ex){
		ApiError apiError = new ApiError(404, ex.getMessage(), new Date());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
	}
}
