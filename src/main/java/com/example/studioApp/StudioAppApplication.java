package com.example.studioApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.studioApp.model.Todo;
import com.example.studioApp.model.TodoRepositoryD;

@SpringBootApplication
public class StudioAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioAppApplication.class, args);
	}


	//next: try to add tasks and get them to see on the home page DONE
	//THIS IS USING H2 DATABASE, NEED TO CHANGE TO MARIADB tai vastaava
	//commandline runner to add test data to database
	@Bean
	public CommandLineRunner demo(TodoRepositoryD trepository) {
		return (args) -> {
			
			Todo a = new Todo("do something", "veera");
			Todo b = new Todo("do something else", "meikäpoika");

			trepository.save(a);
			trepository.save(b);
			
		};
	}	
}
