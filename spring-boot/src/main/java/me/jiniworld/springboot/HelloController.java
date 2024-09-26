package me.jiniworld.springboot;

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
        return user.name +", " + user.email;
    }

    @PutMapping("/ttt")
    public String hello2(@RequestBody User user) {
        return user.name +", " + user.email;
    }

    record User(Long id, String name, String email, int age){

        @Override
        public String toString() {
            return String.format("User(%d): %s", id, name);
        }
    }
}
