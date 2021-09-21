package com.example.store.product_category;

import com.example.store.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product_category")

public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_category_id", nullable = false, unique = true)
    private long categoryId;

    @Column(name = "product_category_name", nullable = false)
    private String name;

    @Column(name = "product_category_created_at", nullable = false)
    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_category_id")
    List<Product> products = new ArrayList<>();


}