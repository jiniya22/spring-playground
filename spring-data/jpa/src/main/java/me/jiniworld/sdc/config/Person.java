package me.jiniworld.sdc.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.AccessType;

@Getter
@ToString
public class Person {
    private final Long id;
    private String firstName;
    private @AccessType(AccessType.Type.PROPERTY) String lastName;

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person withId(Long id) {
        return new Person(id, this.firstName, this.lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
