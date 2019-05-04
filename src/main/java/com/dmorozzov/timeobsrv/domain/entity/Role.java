package com.dmorozzov.timeobsrv.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role extends BaseEntity<Long> {

    public enum RoleName {
        ROLE_USER,
        ROLE_ADMIN
    }

    @Id
    @SequenceGenerator(name = "role_pkey", sequenceName = "ROLE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_pkey")
    private Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
}
