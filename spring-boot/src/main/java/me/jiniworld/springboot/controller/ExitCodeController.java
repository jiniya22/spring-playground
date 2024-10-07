package me.jiniworld.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.jiniworld.springboot.domain.SimpleData;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/exit-code")
@RestController
class ExitCodeController {

    private final ApplicationContext applicationContext;
    private final ExitCodeGenerator exitCodeGenerator;

    @PostMapping
    public String exitCode(@RequestBody SimpleData<String> req) {
        if ("q".equals(req.data())) {
            SpringApplication.exit(applicationContext, exitCodeGenerator);
        }
        return req.data();
    }

}
