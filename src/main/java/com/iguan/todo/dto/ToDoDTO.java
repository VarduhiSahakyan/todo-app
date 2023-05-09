package com.iguan.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ToDoDTO {

    private Integer id;

    private String name;

    @Setter
    private int priority;

    @Setter
    private String status;

}