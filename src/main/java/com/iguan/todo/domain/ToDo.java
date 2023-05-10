package com.iguan.todo.domain;

import com.iguan.todo.enums.Priority;
import com.iguan.todo.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "todo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    @Setter
    private String name;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
