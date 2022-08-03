package com.sirvja.timetrackingservice.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Task(@Id String id, @NonNull String project) {
    public Task(String id){
        this(
                id,
                switch (id.split("-")[0]){
                    case "ver" -> "verkkokalvo";
                    case "vi" -> "vaikeatihosairaudet";
                    default -> "no project";
                }
        );
    }
}
