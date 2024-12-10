package me.jiniworld.sdc.service;

import me.jiniworld.sdc.store.jpa.user.User;

public interface UserService {
    User findById(Long id);
    User save(User user);
}
