package me.jiniworld.sdc.service;

import me.jiniworld.sdc.store.jpa.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User save(User user);

    User jiniworldUsername(String username);
    List<User> findAllByEmailContains(String email);
    List<User> findAllByAddress_zipCode(String city);

    Page<User> findAllByAddress__tagContains(String tag, Pageable pageable);

    List<User> phone(String fPhone, String sPhone, int size);
}
