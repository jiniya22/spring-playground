package me.jiniworld.sdc.web;

import lombok.RequiredArgsConstructor;
import me.jiniworld.sdc.service.UserService;
import me.jiniworld.sdc.store.jpa.user.User;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public User hello(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }

    @PostMapping("")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
