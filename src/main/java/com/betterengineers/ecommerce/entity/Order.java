package com.betterengineers.ecommerce.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id") // Renamed to class_id format
    private Long orderId;

    private String status;
    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id") // Renamed to follow class_id format
    private User user;

    @ManyToOne
    @JoinColumn(name = "cart_id") // Renamed to follow class_id format
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "payment_id") // Renamed to follow class_id format
    private Payment payment;
}


