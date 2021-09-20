package com.example.store.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {

    // This is adding pagination functionality
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findProductByProductName(String name);

}
