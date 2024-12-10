package me.jiniworld.sdc.service;

import lombok.RequiredArgsConstructor;
import me.jiniworld.sdc.config.Person;
import me.jiniworld.sdc.config.props.PersonProps;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonProps personProps;

    @GetMapping
    public String get() {
        Person person1 = new Person(personProps.getId(), personProps.getFirstName(), personProps.getLastName());
        Person person2 = person1.withId(222L);
        return person2.toString();
    }
}
