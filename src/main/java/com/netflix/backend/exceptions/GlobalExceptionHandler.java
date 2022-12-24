package com.netflix.backend.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> invalidCredentialsExceptionHandler(InvalidCredentialsException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        Map<String, String> map = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((err)->{
            String fieldErrName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            map.put(fieldErrName,message);
        });
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateEntryException.class)
    public  ResponseEntity<?> duplicateEntryExceptionExceptionHandler(DuplicateEntryException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ServerErrorException.class)
    public  ResponseEntity<?> MailSMSExceptionHandler(ServerErrorException ex){
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ExpiredJwtException.class)
    public  ResponseEntity<?> JWTExpiredExceptionHandler(){
        return new ResponseEntity<>("JWT token has expired", HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(SignatureException.class)
    public  ResponseEntity<?> InvalidJWTExceptionHandler(){
        return new ResponseEntity<>("Not a valid JWT token", HttpStatus.UNAUTHORIZED);
    }
}