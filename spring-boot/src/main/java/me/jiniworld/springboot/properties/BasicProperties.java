package me.jiniworld.springboot.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BasicProperties {
    @Value("${custom.name:empty}")
    private String customName;
    @Value("${custom.group:empty}")
    private String customGroup;

    @Value("${demo.title:empty}")
    private String demoTitle;
}
