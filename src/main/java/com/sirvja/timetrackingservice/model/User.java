package com.sirvja.timetrackingservice.model;

public record User(Integer id, String firstName, String lastName, Role role, Title title, String email, String password) {
}
