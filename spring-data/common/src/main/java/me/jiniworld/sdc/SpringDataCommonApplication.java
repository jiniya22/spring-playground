package me.jiniworld.sdc;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@RequiredArgsConstructor
@ConfigurationPropertiesScan("me.jiniworld.sdc.config")
@SpringBootApplication
public class SpringDataCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataCommonApplication.class, args);
    }

}
