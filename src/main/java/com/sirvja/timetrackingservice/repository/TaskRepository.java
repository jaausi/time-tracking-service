package com.sirvja.timetrackingservice.repository;

import com.sirvja.timetrackingservice.model.Hour;
import com.sirvja.timetrackingservice.model.Task;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TaskRepository extends ReactiveCrudRepository<Task, String> {
    @Tailable
    Flux<Hour> findWithTailableCursorBy();
}
