package me.jiniworld.sdc.config.props;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "person")
public class PersonProps {
    private final Long id;
    private final String firstName;
    private final String lastName;

    PersonProps(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
