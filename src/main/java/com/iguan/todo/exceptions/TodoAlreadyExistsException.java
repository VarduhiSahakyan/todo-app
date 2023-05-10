package com.iguan.todo.exceptions;

public class TodoAlreadyExistsException extends RuntimeException {

    public TodoAlreadyExistsException(String message) {
        super(message);
    }

}
