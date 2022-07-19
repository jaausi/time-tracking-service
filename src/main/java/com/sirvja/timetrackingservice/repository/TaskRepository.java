package com.sirvja.timetrackingservice.repository;

import com.sirvja.timetrackingservice.model.Role;
import com.sirvja.timetrackingservice.model.Task;
import com.sirvja.timetrackingservice.model.Title;
import com.sirvja.timetrackingservice.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(String id) {
        return tasks.stream()
                .filter(task -> task.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostConstruct
    private void init() {
        tasks.add(new Task("VER-1", "Verkkokalvo"));
    }
}
