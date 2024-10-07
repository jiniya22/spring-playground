package me.jiniworld.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/spring-application")
@RestController
class SpringApplicationController {

    private final ApplicationArguments applicationArguments;

    @GetMapping
    public Data applicationArguments() {
        Map<String, Object> options = new HashMap<>();
        applicationArguments.getOptionNames().forEach(optionName -> options.put(optionName, applicationArguments.getOptionValues(optionName)));

        return new Data(List.of(applicationArguments.getSourceArgs()), options, applicationArguments.getNonOptionArgs());
    }

    record Data(List<String> sourceArgs, Map<String, Object> options, List<String> nonOptionArgs) {
    }
}
