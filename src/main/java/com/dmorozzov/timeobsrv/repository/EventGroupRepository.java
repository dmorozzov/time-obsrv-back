package com.dmorozzov.timeobsrv.repository;

import com.dmorozzov.timeobsrv.domain.entity.EventGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventGroupRepository extends JpaRepository<EventGroup, Long> {
}
