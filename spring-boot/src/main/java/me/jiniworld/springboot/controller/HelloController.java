package me.jiniworld.springboot.controller;

import me.jiniworld.springboot.domain.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/hello")
@RestController
class HelloController {

    @GetMapping
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping
    public String hello(@RequestBody User user) {
        return user.name() +", " + user.email();
    }

    @PutMapping("/ttt")
    public String hello2(@RequestBody User user) {
        return user.name() +", " + user.email();
    }

}
