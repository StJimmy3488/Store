package com.example.store.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProductService {

    ProductRepository productRepository;

    public Product saveProduct(Product product) {
        product.setProductCreatedAt(LocalDate.now());
        return productRepository.save(product);
    }




}
