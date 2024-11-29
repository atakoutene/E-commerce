package com.betterengineers.ecommerce.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id") // Renamed to class_id format
    private Long invoiceId;

    private String billingDetails;
    private String shippingDetails;
    private String invoiceNumber;

    @ManyToOne
    @JoinColumn(name = "order_id") // Renamed to follow class_id format
    private Order order;
}


