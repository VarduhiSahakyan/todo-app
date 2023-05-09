package com.iguan.todo.exceprions;

public class TodoAlreadyExistsException extends RuntimeException {

    public TodoAlreadyExistsException(String message) {
        super(message);
    }

}
