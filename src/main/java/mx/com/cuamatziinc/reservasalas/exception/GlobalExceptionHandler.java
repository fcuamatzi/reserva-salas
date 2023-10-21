package mx.com.cuamatziinc.reservasalas.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import mx.com.cuamatziinc.reservasalas.dto.ResponseErrorCustom;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidExceptionException(MethodArgumentNotValidException exception, HttpServletRequest request) {
		
		ResponseErrorCustom responseErrorCustom = new ResponseErrorCustom();
		
		responseErrorCustom.setSourceMessage(exception.getLocalizedMessage());
		responseErrorCustom.setUrl(request.getRequestURL().toString());
		responseErrorCustom.setMethod(request.getMethod());
		responseErrorCustom.setTimestamp(LocalDateTime.now());
		
		responseErrorCustom.setMessage("Solicitud no valida - ");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseErrorCustom);
		
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerGenericException(Exception exception, HttpServletRequest request) {
		
		ResponseErrorCustom responseErrorCustom = new ResponseErrorCustom();
		
		responseErrorCustom.setSourceMessage(exception.getLocalizedMessage());
		responseErrorCustom.setUrl(request.getRequestURL().toString());
		responseErrorCustom.setMethod(request.getMethod());
		
		responseErrorCustom.setMessage("Ha ocurrido un error");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseErrorCustom);
		
	}

}
