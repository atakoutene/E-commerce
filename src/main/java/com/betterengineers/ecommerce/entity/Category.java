package com.betterengineers.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id") // Renamed to class_id format
    private Long categoryId;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}


