package com.iguan.todo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private int statusCode;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

}
