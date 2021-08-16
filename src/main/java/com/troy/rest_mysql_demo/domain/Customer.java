package com.troy.rest_mysql_demo.domain;

import com.troy.rest_mysql_demo.model.CustomerStatus;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Customer {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer ban;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStanding;

    @Column(nullable = false)
    private Integer activeLines;

    @Column(nullable = false)
    private Double remainingBalance;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @PrePersist
    public void prePersist() {
        dateCreated = OffsetDateTime.now();
        lastUpdated = dateCreated;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = OffsetDateTime.now();
    }

}
