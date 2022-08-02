package com.sirvja.timetrackingservice.repository;

import com.sirvja.timetrackingservice.model.*;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface HourRepository extends ReactiveCrudRepository<Hour, String> {

    @Tailable
    Flux<Hour> findWithTailableCursorBy();
}
