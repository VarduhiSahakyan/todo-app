package com.iguan.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ToDoDTO {

    private Integer id;

    @Setter
    private String name;

    @Setter
    private int priority;

    @Setter
    private String status;

    public void setName(String name) {
        this.name = name;
    }
}