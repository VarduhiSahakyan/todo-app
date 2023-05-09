package com.iguan.todo.controller;

import com.iguan.todo.dto.ToDoDTO;
import com.iguan.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService service;

    @GetMapping
    public ResponseEntity<Page<ToDoDTO>> getAllToDos(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize){
        return ResponseEntity.ok(service.getAllToDos(page, pageSize));
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<ToDoDTO> getToDoById(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.getToDoById(id));
    }

    @PostMapping
    public void addToDo(@RequestBody ToDoDTO todo){
        service.addToDo(todo);
        ResponseEntity.ok();
    }

    @PutMapping
    public ResponseEntity<ToDoDTO> updateToDo(@RequestBody ToDoDTO todo) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.updateTodoFields(todo));
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        service.deleteToDo(id);
    }

}
