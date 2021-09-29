package com.example.store.product;

import com.example.store.product_category.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    // Show all products existing in DB paginated
    @GetMapping("/all_products")
    public String getAllProducts(Model model) {
        model.addAttribute("all_product_categories", productCategoryService.findAlProductCategories());
        return getAllProductsByPage(model, 1, "productName", "asc");
    }


    @GetMapping("/all_products/page/{pageNumber}")
    public String getAllProductsByPage(
            Model model,
            @PathVariable("pageNumber") int currentPage,
            @Param("sortField") String sortField,
            @Param("sortDirection") String sortDirection) {
        Page<Product> page = productService.findAllPageable(currentPage, sortField, sortDirection);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("all_products", page.getContent());
        model.addAttribute("paginationLink", "/products/all_products/page/");
        return "/products/all_products";
    }

    @GetMapping("/product/{id}")
    public String viewProduct(@PathVariable("id") Long productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "/products/product";
    }

}
