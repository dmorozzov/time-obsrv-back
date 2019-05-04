package com.dmorozzov.timeobsrv.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "event")
@Getter
@Setter
public class Event extends AuditEntity<Long> {

    @Id
    @SequenceGenerator(name = "event_pkey", sequenceName = "EVENT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_pkey")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private EventGroup group;
}
