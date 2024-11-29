package com.betterengineers.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id") // Renamed to class_id format
    private Long productId;

    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private String imageUrl;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "category_id") // Renamed to follow class_id format
    private Category category;
}



