package com.example.studioApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.studioApp.model.Todo;
import com.example.studioApp.model.TodoRepositoryD;
import com.example.studioApp.model.TodoRepositoryS;

@SpringBootApplication
public class StudioAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioAppApplication.class, args);
	}


	//next: try to add tasks and get them to see on the home page DONE
	//THIS IS USING H2 DATABASE, NEED TO CHANGE TO MARIADB tai vastaava
	//commandline runner to add test data to database
	@Bean
	public CommandLineRunner demo(TodoRepositoryD trepositoryd, TodoRepositoryS trepositorys) {
		return (args) -> {
			
			Todo a = new Todo("downstairsTEST", "veera");
			Todo b = new Todo("do something else", "meikäpoika");

			Todo c = new Todo("sumuTEST", "veera");
			Todo d = new Todo("do something else", "meikäpoika");

			
			trepositoryd.save(a);
			trepositoryd.save(b);
			
			trepositorys.save(c);
			trepositorys.save(d);
			
		};
	}	
}
