package me.jiniworld.sdc.service.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByEmailContains(String email);
}
