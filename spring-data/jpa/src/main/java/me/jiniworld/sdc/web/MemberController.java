package me.jiniworld.sdc.web;

import lombok.RequiredArgsConstructor;
import me.jiniworld.sdc.domain.UserDetail;
import me.jiniworld.sdc.service.UserService;
import me.jiniworld.sdc.service.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
class MemberController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDetail hello(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/email/{email}")
    public List<UserDetail> findByEmailContains(@PathVariable("email") String email) {
        return userService.findAllByEmailContains(email);
    }

    @PostMapping("")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
