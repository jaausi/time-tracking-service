package com.sirvja.timetrackingservice.repository;

import com.sirvja.timetrackingservice.model.Title;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TitleRepository extends ReactiveCrudRepository<Title, String> {
    @Query("{ 'name' :  ?0 }")
    Mono<Title> findOneByName(String name);
}
