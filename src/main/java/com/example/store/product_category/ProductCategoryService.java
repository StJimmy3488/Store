package com.example.store.product_category;

import com.example.store.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAlProductCategories() {
        return  productCategoryRepository.findAll();
    }

    public ProductCategory findById(Long categoryId) {
        return productCategoryRepository.getById(categoryId);
    }

    public void deleteCategoryById(Long id) {
        productCategoryRepository.deleteById(id);
    }

    public Page<ProductCategory> findAllPageable(int pageNumber, String sortField, String sortDirection) {
        Sort sort = Sort.by("categoryName");
        sort = sortDirection.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 20, sort);
        return productCategoryRepository.findAll(pageable);
    }

    public ProductCategory saveOrUpdateProductCategory(ProductCategory productCategory) {
        productCategory.setCategoryCreatedAt(LocalDate.now());
        return productCategoryRepository.save(productCategory);
    }

}
