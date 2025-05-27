package me.jiniworld.sdc.service.user;

import jakarta.persistence.*;
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

    @Embedded
    private Address address;

    @Embedded
    private String zipCode;

    private String phone;

    protected User() {
        this.userId = null;
    }

    public User(Long userId, String username, String email, Address address) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    User withUserId(Long id) {
        return new User(id, this.username, this.email, this.address);
    }

    @PrePersist
    void prePersist() {
        this.active = true;
    }

}
