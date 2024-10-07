package me.jiniworld.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

	@Order(1)
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> log.info("commandLineRunner bean : {}", Arrays.toString(args));
	}

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 42;
	}

}
