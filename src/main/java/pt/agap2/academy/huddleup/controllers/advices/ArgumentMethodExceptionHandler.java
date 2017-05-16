package pt.agap2.academy.huddleup.controllers.advices;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pt.agap2.academy.huddleup.business.HorusErrors;

@ControllerAdvice
public class ArgumentMethodExceptionHandler extends ResponseEntityExceptionHandler {
	

    @ExceptionHandler(value = { MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleConflict(MethodArgumentTypeMismatchException ex, WebRequest request) {  	
    	HorusErrors errors = new HorusErrors(  LocaleContextHolder.getLocale()  ); 
    	errors.addError("error.generic.invalid-parameter", ex.getParameter().getParameterName());
        return this.handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
}