package me.jiniworld.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.jiniworld.springboot.properties.BasicProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/properties")
@RestController
class PropertiesController {

    private final BasicProperties basicProperties;

    @GetMapping("/name")
    public String name() {
        return "name: " + basicProperties.getName();
    }
}
