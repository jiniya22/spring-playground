package me.jiniworld.sdc.service;

import me.jiniworld.sdc.store.jpa.user.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User save(User user);

    User jiniworldUsername(String username);
    List<User> findAllByEmailContains(String email);
}
