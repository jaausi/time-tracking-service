package com.sirvja.timetrackingservice.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
@Document
public record Hour(@NonNull String taskId, @NonNull Topic topic, @NonNull String description, @NonNull LocalDateTime startTime, LocalDateTime endTime, @NonNull String userId) {

    @Id
    private static Integer id;

    public enum Topic{
        PLAN,
        CODE,
        REVIEW,
        TEST,
        OTHER
    }
}
