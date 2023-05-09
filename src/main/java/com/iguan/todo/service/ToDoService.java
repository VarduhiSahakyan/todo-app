package com.iguan.todo.service;

import com.iguan.todo.domain.ToDo;
import com.iguan.todo.dto.ToDoDTO;
import com.iguan.todo.exceprions.TodoAlreadyExistsException;
import com.iguan.todo.exceprions.TodoNotFoundException;
import com.iguan.todo.mapper.Mapper;
import com.iguan.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "todos")
public class ToDoService {

    private final ToDoRepository repository;
    private final Mapper mapper;
    private Logger logger = LoggerFactory.getLogger(ToDoService.class);

    @Transactional(readOnly = true)
    @Cacheable
    public Page<ToDoDTO> getAllToDos(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return new PageImpl<>(mapper.mapList(repository.findAll(paging), ToDoDTO.class), paging, repository.count());
    }

    @Transactional(readOnly = true)
    @Cacheable
    public ToDoDTO getToDoById(Integer id) {
        ToDo todo = repository.findToDoById(id);
        todoNotFound(id);
        return mapper.convertToDto(todo, ToDoDTO.class);
    }

    @Transactional
    public void addToDo(ToDoDTO toDoDTO) {
        repository.save(mapper.convertToEntity(toDoDTO, ToDo.class));
    }

    @Transactional
    public ToDoDTO updateTodoFields(Integer id, ToDoDTO toDoDTO) {
        ToDo todo = repository.findToDoById(id);
        todoNotFound(id);
        todo.setPriority(toDoDTO.getPriority());
        todo.setStatus(toDoDTO.getStatus());
        repository.save(todo);
        return mapper.convertToDto(todo, ToDoDTO.class);
    }

    @Transactional
    public void deleteToDo(Integer id) {
        todoNotFound(id);
        repository.deleteById(id);
    }

    public void todoNotFound(Integer id) {
        ToDo todo = repository.findToDoById(id);
        if (todo == null) {
            logger.error("Todo not exist!");
            logger.debug("Todo not exist whit id: {}", id);
            throw new TodoNotFoundException("Todo not exist");
        }
    }
}
