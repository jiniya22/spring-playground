package me.jiniworld.sdc.domain;

public record UserDetail(
        Long userId,
        String username,
        String email,
        String address,
        String fPhone,
        String sPhone,
        boolean active
) {
}
