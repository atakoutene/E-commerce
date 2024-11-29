package com.betterengineers.ecommerce.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id") // Renamed to class_id format
    private Long personId;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id") // Renamed to follow class_id format
    private User user;

    @PrePersist
    public void prePersist() {
        // Logic to set creation timestamp
    }

    @PreUpdate
    public void preUpdate() {
        // Logic to set update timestamp
    }
}


