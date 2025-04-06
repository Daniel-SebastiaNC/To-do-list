package br.com.danielsbastian.desafio_todolist.repository;

import br.com.danielsbastian.desafio_todolist.entity.Todo;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class TodoRepositoryTest {

    @Autowired
    TodoRepository repository;

    @Autowired
    EntityManager entityManager;


    @Test
    void findTodoByNameSuccess() {
        var name = "Todo 3";
        var todo = new Todo("Todo 3", "Desc Todo 5", false, 3);
        entityManager.persist(todo);

        Optional<Todo> todoByName = repository.findTodoByName(name);
        assertThat(todoByName.isPresent()).isTrue();
    }

    @Test
    void findTodoByNameFail(){
        var name = "Todo 2";
        var todo = new Todo("Todo 3", "Desc Todo 5", false, 3);
        entityManager.persist(todo);

        Optional<Todo> todoByName = repository.findTodoByName(name);
        assertThat(todoByName.isEmpty()).isTrue();
    }
}