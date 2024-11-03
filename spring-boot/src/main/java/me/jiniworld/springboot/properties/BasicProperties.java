package me.jiniworld.springboot.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BasicProperties {
    @Value("${name}")
    private String name;
}
