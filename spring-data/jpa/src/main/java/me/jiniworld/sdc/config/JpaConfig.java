package me.jiniworld.sdc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"me.jiniworld.sdc.store.jpa"})
@Configuration
public class JpaConfig {
}
