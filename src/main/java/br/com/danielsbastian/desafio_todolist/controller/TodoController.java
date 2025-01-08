package br.com.danielsbastian.desafio_todolist.controller;

import br.com.danielsbastian.desafio_todolist.entity.Todo;
import br.com.danielsbastian.desafio_todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;
    //@Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> addTodo(@RequestBody @Valid Todo todo){
        return todoService.addTodo(todo);
    }

    @GetMapping
    List<Todo> listTodo(){
        return todoService.listTodo();
    }

    @PutMapping
    List<Todo> updateTodo(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> deleteTodo(@PathVariable("id") Long id){
        return todoService.deleteTodo(id);
    }


}
