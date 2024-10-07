package me.jiniworld.springboot.domain;

public record User(Long id, String name, String email, int age) {

    @Override
    public String toString() {
        return String.format("User(%d): %s", id, name);
    }
}