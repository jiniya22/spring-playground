package me.jiniworld.sdc;

import lombok.RequiredArgsConstructor;
import me.jiniworld.sdc.config.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@RequiredArgsConstructor
@ConfigurationPropertiesScan("me.jiniworld.sdc.config")
@SpringBootApplication
public class SpringDataCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataCommonApplication.class, args);
    }

}
