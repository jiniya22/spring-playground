package me.jiniworld.sdc.store.jpa.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.email like '%@jiniworld.me'")
    Optional<User> findByUsername(String username);

    List<User> findAllByEmailContains(String email);

    List<User> findAllByAddressCity(String city);

    List<User> findAllByAddress_ZipCode(String zipCode);
}
