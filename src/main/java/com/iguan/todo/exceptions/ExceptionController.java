package com.iguan.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionController {


        @ExceptionHandler(value = {TodoAlreadyExistsException.class})
        public ResponseEntity<Object> handleAlreadyExistsException(TodoAlreadyExistsException e) {

            HttpStatus badRequest = HttpStatus.BAD_REQUEST;
            ExceptionResponse exception = new ExceptionResponse(
                    e.getMessage(),
                    badRequest.value(),
                    badRequest,
                    ZonedDateTime.now(ZoneId.of("Z"))
            );
            return new ResponseEntity<>(exception, badRequest);
        }

        @ExceptionHandler(value = {TodoNotFoundException.class})
        public ResponseEntity<Object> handleNotFoundException(TodoNotFoundException e) {

            HttpStatus badRequest = HttpStatus.BAD_REQUEST;
            ExceptionResponse exception = new ExceptionResponse(
                    e.getMessage(),
                    badRequest.value(),
                    badRequest,
                    ZonedDateTime.now(ZoneId.of("Z"))
            );
            return new ResponseEntity<>(exception, badRequest);
        }
    }
