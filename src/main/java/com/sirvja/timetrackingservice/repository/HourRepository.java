package com.sirvja.timetrackingservice.repository;

import com.sirvja.timetrackingservice.model.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HourRepository {

    private final TaskRepository taskRepository;
    private final OwnerRepository ownerRepository;

    private List<Hour> hours = new ArrayList<>();

    public HourRepository(TaskRepository taskRepository, OwnerRepository ownerRepository) {
        this.taskRepository = taskRepository;
        this.ownerRepository = ownerRepository;
    }

    public List<Hour> findAll() {
        return hours;
    }

    public Hour findOne(Integer id) {
        return hours.stream()
                .filter(book -> book.id() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Hour not found"));
    }

    @PostConstruct
    private void init() {
        hours.add(new Hour(1,
                new Task("VER-1", "Verkkokalvo"),
                Topic.CODE,
                "Koodasin ensimmäisen ominaisuuden verkkokalvorekisteriin",
                LocalDateTime.now().minus(Duration.ofHours(2)),
                LocalDateTime.now(),
                ownerRepository.findById(1))
        );
        hours.add(new Hour(2,
                new Task("VER-2", "Verkkokalvo"),
                Topic.CODE,
                "Koodasin toisen ominaisuuden verkkokalvorekisteriin",
                LocalDateTime.now().minus(Duration.ofHours(3)),
                LocalDateTime.now().minus(Duration.ofHours(2)),
                ownerRepository.findById(2))
        );
        hours.add(new Hour(3,
                new Task("VER-3", "Verkkokalvo"),
                Topic.CODE,
                "Koodasin kolmannen ominaisuuden verkkokalvorekisteriin",
                LocalDateTime.now().minus(Duration.ofHours(6)),
                LocalDateTime.now().minus(Duration.ofHours(3)),
                ownerRepository.findById(3))
        );

    }
}
