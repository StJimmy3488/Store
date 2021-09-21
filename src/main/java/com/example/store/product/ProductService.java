package com.example.store.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveOrUpdateProduct(Product product) {
        product.setProductCreatedAt(LocalDate.now());
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findByProductName(String name) {
        return productRepository.findProductByProductName(name);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);

    }

}
