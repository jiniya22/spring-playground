package me.jiniworld.sdc.service;

import me.jiniworld.sdc.domain.UserDetail;
import me.jiniworld.sdc.service.user.User;

import java.util.List;

public interface UserService {
    UserDetail findById(Long id);
    User save(User user);
    List<UserDetail> findAllByEmailContains(String email);
}
