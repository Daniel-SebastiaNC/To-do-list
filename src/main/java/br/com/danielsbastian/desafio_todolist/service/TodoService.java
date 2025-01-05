package br.com.danielsbastian.desafio_todolist.service;

import br.com.danielsbastian.desafio_todolist.entity.Todo;
import br.com.danielsbastian.desafio_todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    //@Autowired
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> listTodo(){
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );

        return todoRepository.findAll(sort);
    }

    public List<Todo> addTodo(Todo todo) {
        todoRepository.save(todo);
        return listTodo();
    }

    public List<Todo> updateTodo(Todo todo){
        todoRepository.save(todo);
        return listTodo();
    }

    public List<Todo> deleteTodo(Long id){
        todoRepository.deleteById(id);
        return listTodo();
    }




}
