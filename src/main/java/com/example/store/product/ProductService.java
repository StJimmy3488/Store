package com.example.store.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Product findById(Long productId) {
        return productRepository.getById(productId);
    }


    public Optional<Product> findByProductName(String name) {
        return productRepository.findProductByProductName(name);
    }


    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


    // Find all products paginated
    public Page<Product> findAllPageable(int pageNumber, String sortField, String sortDirection) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 8);
        return productRepository.findAll(pageable);
    }

}
