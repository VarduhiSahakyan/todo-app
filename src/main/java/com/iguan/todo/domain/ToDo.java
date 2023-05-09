package com.iguan.todo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String name;

    @Setter
    @Column
    private int priority;

    @Setter
    @Column
    private String status;

}
