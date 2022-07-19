package com.sirvja.timetrackingservice.controller;

import com.sirvja.timetrackingservice.model.User;
import com.sirvja.timetrackingservice.repository.OwnerRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private final OwnerRepository ownerRepository;

    public UserController(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    @QueryMapping
    public List<User> allUsers(){
        return ownerRepository.findAll();
    }
}
