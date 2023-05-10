package com.iguan.todo.dto;

import com.iguan.todo.enums.Priority;
import com.iguan.todo.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoUpdateDTO {

    private Integer id;

    private Priority priority;

    private Status status;
}
