package com.example.studioApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.studioApp.web.DownstairsController;
import com.example.studioApp.web.HomeController;
import com.example.studioApp.web.SumuController;
import com.example.studioApp.web.UpstairsController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstroreApplicationTests {
	
	@Autowired
	private HomeController hcontroller;
	
	@Autowired
	private SumuController scontroller;
	
	@Autowired
	private DownstairsController dcontroller;
	
	@Autowired
	private UpstairsController ucontroller;
	
	@Test
	void contextLoads()throws Exception {
		assertThat(hcontroller).isNotNull();
		assertThat(dcontroller).isNotNull();
		assertThat(scontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
		
	}

}