package com.example.store.product_category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_category_id", nullable = false)
    private long categoryId;

    @Column(name = "product_category_name", nullable = false)
    private String name;

    @Column(name = "product_category_created_at", nullable = false)
    private LocalDate createdAt;
}