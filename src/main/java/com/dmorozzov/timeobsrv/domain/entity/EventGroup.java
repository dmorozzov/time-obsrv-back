package com.dmorozzov.timeobsrv.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event_group")
@Getter
@Setter
public class EventGroup extends AuditEntity<Long> {

    @Id
    @SequenceGenerator(name = "event_group_pkey", sequenceName = "EVENT_GROUP_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_group_pkey")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<Event> events = new ArrayList<>();
}
