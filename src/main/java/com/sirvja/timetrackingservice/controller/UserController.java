package com.sirvja.timetrackingservice.controller;

import com.sirvja.timetrackingservice.model.TimeTrackingUser;
import com.sirvja.timetrackingservice.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @QueryMapping
    public Iterable<TimeTrackingUser> allUsers(){
        return userRepository.findAll().toIterable();
    }

    public Optional<TimeTrackingUser> userById(String id) {
        return userRepository.findById(id).blockOptional();
    }
}
