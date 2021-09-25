package com.example.store.product_category;

import com.example.store.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAlProductCategories() {
        return  productCategoryRepository.findAll();
    }

}
