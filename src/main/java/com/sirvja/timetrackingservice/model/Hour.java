package com.sirvja.timetrackingservice.model;

import java.time.LocalDateTime;

public record Hour(Integer id, Task task, Topic topic, String description, LocalDateTime startTime, LocalDateTime endTime, User owner) {
}
