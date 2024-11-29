package com.betterengineers.ecommerce.entity;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Renamed to class_id format
    private Long userId;

    private String username;
    private String passwordHash;
    private String email;
    private boolean verified;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToOne(mappedBy = "user")
    private Person person;

    @PrePersist
    public void prePersist() {
        // Logic to set the creation timestamp
    }

    @PreUpdate
    public void preUpdate() {
        // Logic to set the update timestamp
    }
}


