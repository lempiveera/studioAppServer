package com.example.studioApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import com.example.studioApp.model.User;
import com.example.studioApp.model.Present;
import com.example.studioApp.model.PresentRepository;
import com.example.studioApp.model.Priority;
import com.example.studioApp.model.PriorityRepository;
import com.example.studioApp.model.Todo;
import com.example.studioApp.model.TodoRepository;
//import com.example.studioApp.model.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudioAppRepositoryTest {

	@Autowired
	private TodoRepository trepo;

	@Autowired
	private PriorityRepository priorityrepo;

//	@Autowired
//	private UserRepository urepo;

	@Autowired
	private PresentRepository presentrepo;

	@Test
	public void createNewTodo() {
		Todo todo = new Todo("S", "clean", "veera", new Priority("no urgency"));
		trepo.save(todo);
		assertThat(todo.getId()).isNotNull();
	}

	@Test
	public void findByPlaceShouldReturnTodo() {
		List<Todo> todos = trepo.findByPlace("S");
		assertThat(todos).isNotEmpty();
		assertThat(todos.get(0).getPlace()).isEqualTo("S");
	}
	
	@Test
	public void deleteTodoByPlace() {
		long deletedTodos = trepo.deleteByPlace("S");
		assertThat(deletedTodos).isNotNull();
	}
	
	@Test
	public void findByUrgencyShouldReturnPriority() {
		List<Priority> priorities = priorityrepo.findByUrgency("Low");
		assertThat(priorities).hasSizeGreaterThan(0);
		assertThat(priorities.get(0).getUrgency()).isEqualTo("Low");
	}
	
	@Test
	public void deletePriorityByUregncy() {
		long deletedPriorities = priorityrepo.deleteByUrgency("Low");
		assertThat(deletedPriorities).isGreaterThan(0);
	}
	
/* 	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@email.com","USER");
		urepo.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = urepo.findByUsername("user");
		assertThat(user.getUsername()).isEqualTo("user");
	}
	
	@Test
	public void deleteUserByUsername() {
		long deletedUsers = urepo.deleteByUsername("user");
		assertThat(deletedUsers).isEqualTo(1);
	}
	*/
	
	@Test
	public void findByPersonShouldReturnPresent() {
		List<Present> presentNow = presentrepo.findByPerson("Veera");
		assertThat(presentNow).hasSizeGreaterThan(0);
		assertThat(presentNow.get(0).getPerson()).isEqualTo("Veera");
	}
	
	@Test
	public void deletePresentByPerson() {
		long deletedPresent = presentrepo.deleteByPerson("Veera");
		assertThat(deletedPresent).isGreaterThan(0);
	}
}