package com.iguan.todo.controller;

import com.iguan.todo.dto.ToDoDTO;
import com.iguan.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService service;

    @GetMapping
    public Page<ToDoDTO> getAllToDos(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize){
        return (service.getAllToDos(page, pageSize));
    }

    @GetMapping("/todos/{id}")
    public ToDoDTO getToDoById(@PathVariable Integer id){
        return service.getToDoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addToDo(@RequestBody ToDoDTO todo){
        service.addToDo(todo);
    }

    @PutMapping("/{id}")
    public ToDoDTO updateToDo(@PathVariable Integer id, @RequestBody ToDoDTO todo) {
        return service.updateTodoFields(id, todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteToDo(@PathVariable Integer id){
        service.deleteToDo(id);
    }
}
