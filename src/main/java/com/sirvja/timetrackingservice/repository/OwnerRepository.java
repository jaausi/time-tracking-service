package com.sirvja.timetrackingservice.repository;

import com.sirvja.timetrackingservice.model.Role;
import com.sirvja.timetrackingservice.model.Title;
import com.sirvja.timetrackingservice.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OwnerRepository {
    private List<User> owners = new ArrayList<>();

    public List<User> findAll() {
        return owners;
    }

    public User findById(int id) {
        return owners.stream()
                .filter(user -> user.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostConstruct
    private void init() {
        owners.add(new User(1,
                "Janne",
                "Sirviö",
                Role.ADMIN,
                new Title(1, "Software developer", "Basic level software developer"),
                "janjan.sirvio@gmail.com",
                "swkdjw34Apd!")
        );
        owners.add(new User(2,
                "Jaska",
                "Jokunen",
                Role.USER,
                new Title(1, "Senior Software Developer", "Advanced level software developer"),
                "jaska.jokunen@gmail.com",
                "swkdjw24Apd!")
        );
        owners.add(new User(3,
                "Muumi",
                "Peikko",
                Role.USER,
                new Title(1, "Senior Software Architect", "Extreme level software developer"),
                "muumi.peikko@gmail.com",
                "swkdjw34Apd!")
        );
    }
}
