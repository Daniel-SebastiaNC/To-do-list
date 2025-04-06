
package br.com.danielsbastian.desafio_todolist.service;

import br.com.danielsbastian.desafio_todolist.entity.Todo;
import br.com.danielsbastian.desafio_todolist.repository.TodoRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoService todoService;

    @Mock
    private Todo todo;

    @Test
    void listTodoSuccess() {
        Mockito.when(todoService.listTodo()).thenReturn(new ArrayList<>(Arrays.asList(todo, todo)));

        List<Todo> todos = todoService.listTodo();

        assertEquals(2, todos.size());
    }

    @Test
    void addTodo() {
    }

    @Test
    void updateTodo() {
    }

    @Test
    void deleteTodo() {
    }
}