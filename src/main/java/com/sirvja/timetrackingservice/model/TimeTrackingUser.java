package com.sirvja.timetrackingservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

@Document
@Getter
@Setter
public class TimeTrackingUser extends User {

    @Id
    private String id;
    @NonNull
    private String email;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Role role;
    private Title title;
    @Indexed(unique = true)
    private String username;

    @Builder.Default
    private boolean isAdmin = false;

    public TimeTrackingUser(String username, String password, boolean isAdmin, String email, String firstName, String lastName, Title title) {
        this(username, password, Collections.singleton(new SimpleGrantedAuthority(isAdmin ? Role.ADMIN.name() : Role.USER.name())), email, firstName, lastName, isAdmin ? Role.ADMIN : Role.USER, title);
        this.isAdmin = isAdmin;
    }

    private TimeTrackingUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String email, String firstName, String lastName, Role role, Title title) {
        super(username, password, true, true, true, true, authorities);

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.title = title;
        this.username = username;
    }

    public enum Role{
        ADMIN,
        USER
    }

}
