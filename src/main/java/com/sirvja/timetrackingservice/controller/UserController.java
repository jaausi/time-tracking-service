package com.sirvja.timetrackingservice.controller;

import com.sirvja.timetrackingservice.model.TimeTrackingUser;
import com.sirvja.timetrackingservice.model.Title;
import com.sirvja.timetrackingservice.repository.TitleRepository;
import com.sirvja.timetrackingservice.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;
import java.util.Optional;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final TitleRepository titleRepository;

    public UserController(UserRepository userRepository, TitleRepository titleRepository){
        this.userRepository = userRepository;
        this.titleRepository = titleRepository;
    }

    @QueryMapping
    public Iterable<TimeTrackingUser> allUsers(){
        return userRepository.findAll().toIterable();
    }

    public Optional<TimeTrackingUser> userById(String id) {
        return userRepository.findById(id).blockOptional();
    }

    public Optional<TimeTrackingUser> newUser(String username, String password, String email, String firstname, String lastname, String titleName) {
        Title title = titleRepository.findOneByName(titleName)
                .blockOptional()
                .orElse(
                        titleRepository.save(
                                        new Title(titleName)).blockOptional()
                                .orElseThrow(() -> new IllegalArgumentException(String.format("Couldn't create new object with param: %s", titleName)))
                );

        TimeTrackingUser timeTrackingUser = new TimeTrackingUser(username, password, false, email, firstname, lastname, title);
        Mono<TimeTrackingUser> timeTrackingUserMono = userRepository.save(timeTrackingUser);
        return timeTrackingUserMono.blockOptional();
    }
}
