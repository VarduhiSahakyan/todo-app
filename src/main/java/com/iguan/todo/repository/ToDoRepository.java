package com.iguan.todo.repository;

import com.iguan.todo.domain.ToDo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Integer> {

    List<ToDo> findAll(Pageable pageable);

    ToDo findToDoById(Integer id);

}
