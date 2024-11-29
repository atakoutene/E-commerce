package com.betterengineers.ecommerce.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id") // Renamed to class_id format
    private Long paymentId;

    private String method;
    private String status;
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "order_id") // Renamed to follow class_id format
    private Order order;
}


