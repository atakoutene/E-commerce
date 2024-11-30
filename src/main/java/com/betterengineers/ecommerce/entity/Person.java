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
    @Column(name = "person_id")
    private Long personId;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}


