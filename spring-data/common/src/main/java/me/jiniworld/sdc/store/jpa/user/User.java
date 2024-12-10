package me.jiniworld.sdc.store.jpa.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private final Long id;
    private String username;
    private String email;

    protected User() {
        this.id = null;
    }

    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    User withId(Long id) {
        return new User(id, this.username, this.email);
    }
}
