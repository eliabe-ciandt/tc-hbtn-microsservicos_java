package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(CPFException.class)
    ResponseEntity<CPFException> handleException(CPFException err){

        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage(err.getMessage());
        return new ResponseEntity(uer, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserIdException.class)
    ResponseEntity<UserIdException> handleIdException(UserIdException idException) {

        UserErrorResponse response = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), idException.getMessage());

        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserNameException.class)
    ResponseEntity<UserNameException> handleNameException(UserNameException nameException) {

        UserErrorResponse response = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), nameException.getMessage());

        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

    }

}
