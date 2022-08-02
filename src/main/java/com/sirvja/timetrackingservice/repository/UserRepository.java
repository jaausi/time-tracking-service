package com.sirvja.timetrackingservice.repository;

import com.sirvja.timetrackingservice.model.TimeTrackingUser;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<TimeTrackingUser, String> {

    @Tailable
    Flux<TimeTrackingUser> findWithTailableCursorBy();
}
