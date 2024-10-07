package me.jiniworld.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class MyCommandLineRunner implements CommandLineRunner, Ordered {

    @Override
    public void run(String... args) {
        log.info("MyCommandLineRunner: {}", Arrays.toString(args));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
