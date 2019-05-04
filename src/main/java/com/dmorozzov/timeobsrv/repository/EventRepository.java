package com.dmorozzov.timeobsrv.repository;

import com.dmorozzov.timeobsrv.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
