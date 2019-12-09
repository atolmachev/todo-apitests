package com.atolmachev.todo.controller;

import com.atolmachev.todo.dao.TodoRepository;
import com.atolmachev.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;

    @RequestMapping(method = GET)
    @ResponseBody
    public Collection<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @RequestMapping(method = POST,  headers = {"Content-type=application/json"})
    public ResponseEntity<Todo> postTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoRepository.save(new Todo(todo.getTitle(), todo.isCompleted(), todo.getRank()));
        return new ResponseEntity<Todo>(createdTodo, CREATED);
    }

    @RequestMapping(value = "/{todo-id}", method = DELETE)
    public ResponseEntity deleteTodo(@PathVariable("todo-id") int id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (!todoOptional.isPresent() ) {
            return ResponseEntity.notFound().build();
        }

        todoRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

    //TODO implement update todo
}