package br.com.danielsbastian.desafio_todolist;

import br.com.danielsbastian.desafio_todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testAddTodoSuccess() {
		var todo = new Todo("todo 1", "todo 1 desc", false, 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(todo.getName())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].done").isEqualTo(todo.isDone())
				.jsonPath("$[0].priority").isEqualTo(todo.getPriority());
	}

	@Test
	void testAddTodoFailure() {
		var todo = new Todo("", "", false, 0);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isBadRequest();
	}

}
