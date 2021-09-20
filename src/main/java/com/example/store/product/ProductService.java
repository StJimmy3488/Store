package com.example.store.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
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
