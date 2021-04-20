package com.example.studioApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.studioApp.model.TodoRepository;
import com.example.studioApp.model.Todo;

@SpringBootApplication
public class StudioAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioAppApplication.class, args);
	}

	// next: try to add tasks and get them to see on the home page DONE
	// THIS IS USING H2 DATABASE, NEED TO CHANGE TO MARIADB tai vastaava
	// commandline runner to add test data to database
	@Bean
	public CommandLineRunner demo(TodoRepository trepository) {
		return (args) -> {

			Todo a = new Todo("D", "downstairsTEST", "veera");
			Todo b = new Todo("D", "do something else DD", "meikäpoika");

			Todo c = new Todo("S", "sumuTEST", "veera");
			Todo d = new Todo("S", "do something else SS", "meikäpoika");

			Todo e = new Todo("U", "U_TEST", "veera");
			Todo f = new Todo("U", "do something else UU", "boi");

			// CURRENTLY CRASHES, HOW TO DEAL WITH ENTITIES? FIXED

			trepository.save(a);
			trepository.save(b);

			trepository.save(c);
			trepository.save(d);
			
			trepository.save(e);
			trepository.save(f);

		};
	}
}
