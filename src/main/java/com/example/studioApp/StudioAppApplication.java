package com.example.studioApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.studioApp.model.TodoRepository;
import com.example.studioApp.model.Present;
import com.example.studioApp.model.PresentRepository;
import com.example.studioApp.model.Priority;
import com.example.studioApp.model.PriorityRepository;
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
	public CommandLineRunner demo(TodoRepository trepository, PriorityRepository prepository, 
			PresentRepository presentrepo) {
		return (args) -> {
			
			Priority a = new Priority("Low");
			Priority b = new Priority("Medium");
			Priority c = new Priority("High");

			prepository.save(a);
			prepository.save(b);
			prepository.save(c);

			Todo i = new Todo("D", "downstairsTEST", "veera", a);
			Todo j = new Todo("D", "do something else DD", "meikäpoika", b);

			Todo x = new Todo("S", "sumuTEST", "veera", c);
			Todo y = new Todo("S", "do something else SS", "meikäpoika", a);

			Todo z = new Todo("U", "U_TEST", "veera", b);
			Todo k = new Todo("U", "do something else UU", "boi", c);

			// CURRENTLY CRASHES, HOW TO DEAL WITH ENTITIES? FIXED

			trepository.save(i);
			trepository.save(j);

			trepository.save(x);
			trepository.save(y);
			
			trepository.save(z);
			trepository.save(k);
			
			Present me = new Present("Veera");
			Present you = new Present("Maiju");

			presentrepo.save(me);
			presentrepo.save(you);
		};
	}
}
