package me.jiniworld.sdc.service;

import me.jiniworld.sdc.store.jpa.user.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User save(User user);

    User jiniworldUsername(String username);
    List<User> findAllByEmailContains(String email);
    List<User> findAllByAddress_zipCode(String city);

    List<User> findAllByAddress__tagContains(String tag);

    List<User> phone(String fPhone, String sPhone);
}
