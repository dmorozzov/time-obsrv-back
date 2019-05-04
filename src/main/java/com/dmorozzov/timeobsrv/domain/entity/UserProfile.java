package com.dmorozzov.timeobsrv.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_profile")
@Getter
@Setter
public class UserProfile extends AuditEntity<Long> {

    @Id
    @SequenceGenerator(name = "user_profile_pkey", sequenceName = "USER_PROFILE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_pkey")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
