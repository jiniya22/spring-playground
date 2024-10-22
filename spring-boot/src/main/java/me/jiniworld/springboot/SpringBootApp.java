package me.jiniworld.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootApp.class);
		var applicationStartup = new BufferingApplicationStartup(2048);
		applicationStartup.addFilter(startupStep -> startupStep.getName().matches("spring.beans.instantiate"));
		application.setApplicationStartup(applicationStartup);
		application.run(args);
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
