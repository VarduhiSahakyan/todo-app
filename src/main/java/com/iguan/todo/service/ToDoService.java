package com.iguan.todo.service;

import com.iguan.todo.domain.ToDo;
import com.iguan.todo.dto.ToDoDTO;
import com.iguan.todo.mapper.Mapper;
import com.iguan.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ToDoService {

    private final ToDoRepository repository;
    private final Mapper mapper;

    @Transactional(readOnly = true)
    @Cacheable
    public Page<ToDoDTO> getAllToDos(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return new PageImpl<>(mapper.mapList(repository.findAll(paging), ToDoDTO.class), paging, repository.count());
    }

    @Transactional(readOnly = true)
    @Cacheable
    public ToDoDTO getToDoById(Integer id) throws ChangeSetPersister.NotFoundException {
        ToDo todo = repository.findToDoById(id);
        if (todo == null)
            throw new ChangeSetPersister.NotFoundException();
        return mapper.convertToDto(todo, ToDoDTO.class);
    }

    @Transactional
    public void addToDo(ToDoDTO toDoDTO) {
        repository.save(mapper.convertToEntity(toDoDTO, ToDo.class));
    }

    @Transactional
    public ToDoDTO updateTodoFields(ToDoDTO toDoDTO) throws ChangeSetPersister.NotFoundException {
        Integer id = toDoDTO.getId();
        ToDo todo = repository.findToDoById(id);
        if (todo == null)
            throw new ChangeSetPersister.NotFoundException();
        todo.setPriority(toDoDTO.getPriority());
        todo.setStatus(toDoDTO.getStatus());
        repository.save(todo);
        return mapper.convertToDto(todo, ToDoDTO.class);
    }


    @Transactional
    public void deleteToDo(Integer id) throws ChangeSetPersister.NotFoundException {
        ToDo todo = repository.findToDoById(id);
        if (todo == null)
            throw new ChangeSetPersister.NotFoundException();
        repository.deleteById(id);
    }

}
