package me.jiniworld.sdc.domain;

public record UserSimple(
        Long userId,
        String username,
        String email,
        boolean active
) {
}
