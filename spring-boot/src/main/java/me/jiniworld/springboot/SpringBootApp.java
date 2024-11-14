package me.jiniworld.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootApp.class);
		app.setDefaultProperties(Map.of("spring.config.on-not-found", "ignore"));
		app.run(args);
	}

}
