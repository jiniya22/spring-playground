package me.jiniworld.sdc.store.jpa.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.SQLRestriction;

@Getter
@ToString
@Entity
@SQLRestriction("active = true")
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private final Long userId;
    private String username;
    private String email;
    private boolean active;

    protected User() {
        this.userId = null;
    }

    public User(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    User withUserId(Long id) {
        return new User(id, this.username, this.email);
    }

    @PrePersist
    void prePersist() {
        this.active = true;
    }
}
