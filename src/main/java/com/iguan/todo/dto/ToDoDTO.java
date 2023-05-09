package com.iguan.todo.dto;

import com.iguan.todo.domain.Priority;
import com.iguan.todo.domain.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ToDoDTO {

    private Integer id;

    @Setter
    private String name;

    @Setter
    private Priority priority;

    @Setter
    private Status status;

    public void setName(String name) {
        this.name = name;
    }
}