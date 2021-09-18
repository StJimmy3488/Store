package com.example.store.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private long productId;

    @Column(name = "product_name", nullable = false)
    private long productName;

    @Column(name = "product_short_description", nullable = false)
    private String description;

    @Column(name = "product_quantity", nullable = false)
    private Integer quantity;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @Column(name = "product_created_at", nullable = false)
    private LocalDate createdAt;


}
