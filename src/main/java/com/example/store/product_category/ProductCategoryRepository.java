package com.example.store.product_category;

import com.example.store.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    // This is adding pagination functionality
    Page<ProductCategory> findAll(Pageable pageable);

}
