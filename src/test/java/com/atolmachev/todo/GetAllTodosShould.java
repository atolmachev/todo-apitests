package com.atolmachev.todo;

import com.atolmachev.todo.model.Todo;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DBRider
public class GetAllTodosShould extends TodoControllerTest {
    @Test
    @DataSet(value = "empty.yml", cleanBefore = true)
    public void returnEmptyListWhenNoTodos() {
        Collection<Todo> responseTodos = todosController.getAllTodos();

        assertEquals(Collections.emptyList(), responseTodos);
    }

    @Test
    @DataSet(value = "many_todos.yml", cleanBefore = true)
    public void returnOneTodoWhenHasOne() {
        Collection<Todo> responseTodos = todosController.getAllTodos();

        assertEquals(Lists.list(
                newTodo(1, "Buy eggs"),
                newTodo(2, "Buy milk")
        ), responseTodos);
    }
}