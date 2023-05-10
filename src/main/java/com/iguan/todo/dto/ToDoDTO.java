package com.iguan.todo.dto;

import com.iguan.todo.enums.Priority;
import com.iguan.todo.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoDTO {

    private Integer id;

    private String name;

    private Priority priority;

    private Status status;

}