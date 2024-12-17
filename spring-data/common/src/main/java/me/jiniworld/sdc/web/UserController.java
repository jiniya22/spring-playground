package me.jiniworld.sdc.web;

import lombok.RequiredArgsConstructor;
import me.jiniworld.sdc.service.UserService;
import me.jiniworld.sdc.store.jpa.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public User hello(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/email/{email}")
    public List<User> findByEmailContains(@PathVariable("email") String email) {
        return userService.findAllByEmailContains(email);
    }

    @GetMapping("/jiniworld/{username}")
    public User jiniworldUsername(@PathVariable("username") String username) {
        return userService.jiniworldUsername(username);
    }

    @GetMapping("/zip-codes/{zipCode}")
    public List<User> zipCode(@PathVariable("zipCode") String zipCode) {
        return userService.findAllByAddress_zipCode(zipCode);
    }

    @GetMapping("/tags/{tag}")
    public List<User> tag(@PathVariable("tag") String tag) {
        return userService.findAllByAddress__tagContains(tag);
    }

    @GetMapping("/phones")
    public List<User> phone(@RequestParam String fPhone, @RequestParam String sPhone) {
        return userService.phone(fPhone, sPhone);
    }

    @PostMapping("")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
