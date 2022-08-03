package com.sirvja.timetrackingservice.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Title(@NonNull String name, String description) {

    @Id
    private static Integer id;

    public Title(String name){
        this(
                name,
                null
        );
    }
}
