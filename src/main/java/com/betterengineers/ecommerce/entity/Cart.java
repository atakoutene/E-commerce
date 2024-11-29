package com.betterengineers.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id") // Renamed to class_id format
    private Long cartId;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"), // Renamed to follow class_id format
            inverseJoinColumns = @JoinColumn(name = "product_id") // Renamed to follow class_id format
    )
    private List<Product> products;

    @ManyToOne
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

