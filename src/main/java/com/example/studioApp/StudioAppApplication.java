package com.example.studioApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.studioApp.model.TodoRepository;
import com.example.studioApp.model.User;
import com.example.studioApp.model.UserRepository;
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
			PresentRepository presentrepo, UserRepository urepository) {
		return (args) -> {
			
			//test data, and inserting priorities
			
			Priority a = new Priority("Low");
			Priority b = new Priority("Medium");
			Priority c = new Priority("High");

			prepository.save(a);
			prepository.save(b);
			prepository.save(c);
			
			Todo x = new Todo("D", "downstairsTEST", "meikä", a);

			Todo y = new Todo("S", "sumuTEST", "teikä", b);

			Todo z = new Todo("U", "upstairsTEST", "joku", c);


			trepository.save(x);
			trepository.save(y);		
			trepository.save(z);

			
			Present me = new Present("Me");
			Present you = new Present("You");

			presentrepo.save(me);
			presentrepo.save(you);
			
			
			//this is a comment
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@email.com","USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","admin@email.com" ,"ADMIN");

			urepository.save(user1);
			urepository.save(user2);
		};
	}
}