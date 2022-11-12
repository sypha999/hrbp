package com.arinze.hrbp.exceptions;

import com.arinze.hrbp.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handlerForFailedException(){
        Response response = new Response();
        response.setCode(HttpStatus.FORBIDDEN);
        response.setMessage("Operation could not be performed");
        response.setContent(null);
        return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
    }

}
