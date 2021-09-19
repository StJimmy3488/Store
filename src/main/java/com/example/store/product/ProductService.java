package com.example.store.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // Find all products paginated
    public Page<Product> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber -1, 20);
        return productRepository.findAll(pageable);
    }

}
