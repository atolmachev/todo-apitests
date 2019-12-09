package com.atolmachev.todo;

import com.atolmachev.todo.controller.TodoController;
import com.atolmachev.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoControllerTest {
    @Autowired
    protected TodoController todosController;

    protected Todo newTodo(int id, String title) {
        return new Todo(id, title, false, 1);
    }
}
