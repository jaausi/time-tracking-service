package com.sirvja.timetrackingservice.controller;

import com.sirvja.timetrackingservice.model.Hour;
import com.sirvja.timetrackingservice.model.Task;
import com.sirvja.timetrackingservice.repository.HourRepository;
import com.sirvja.timetrackingservice.repository.TaskRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class HourController {
    private final HourRepository hourRepository;
    private final TaskRepository taskRepository;

    public HourController(HourRepository hourRepository, TaskRepository taskRepository){
        this.hourRepository = hourRepository;
        this.taskRepository = taskRepository;
    }

    @QueryMapping
    public Iterable<Hour> allHours(){
        return hourRepository.findAll().toIterable();
    }

    public Optional<Hour> hourById(String id) {
        return hourRepository.findById(id).blockOptional();
    }

    public Optional<Hour> newHour(String taskId, String topicString, String description, String startTime, String endTime, String userId) {
        Task task = taskRepository.findById(taskId).blockOptional()
                .orElse(
                        taskRepository.save(new Task(taskId))
                                .blockOptional()
                                .orElseThrow(() -> new IllegalArgumentException(String.format("Couldn't create new object with param: %s", taskId)))
                );

        Hour.Topic topic = switch (topicString) {
            case "plan" -> Hour.Topic.PLAN;
            case "code" -> Hour.Topic.CODE;
            case "review" -> Hour.Topic.REVIEW;
            case "test" -> Hour.Topic.TEST;
            case "other" -> Hour.Topic.OTHER;
            default -> Hour.Topic.OTHER;
        };

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; // '2011-12-03T10:15:30'

        Hour hour = new Hour(taskId, topic, description, LocalDateTime.parse(startTime, dateTimeFormatter), LocalDateTime.parse(endTime, dateTimeFormatter), userId);
        Mono<Hour> hourMono = hourRepository.save(hour);
        return hourMono.blockOptional();
    }
}
