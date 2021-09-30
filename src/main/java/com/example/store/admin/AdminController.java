package com.example.store.admin;

import com.example.store.product.Product;
import com.example.store.product.ProductService;
import com.example.store.product_category.ProductCategory;
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
@RequestMapping("/admin")
@RequiredArgsConstructor

public class AdminController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    @GetMapping("/main")
    public String testAdmin() {
        return "/admin/administration";
    }


    // Show all products existing in DB paginated
    // ********************************************
    @GetMapping("/all_products")
    public String getAllProducts(Model model) {
        model.addAttribute("all_product_categories", productService.findAllProducts());
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
        model.addAttribute("all_products", page.getContent());
        model.addAttribute("paginationLink", "/admin/all_products/page/");
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        String reverseSortDirection = sortDirection.equals("asc") ? "asc" : "desc";
        model.addAttribute("reverseSortDirection", reverseSortDirection);
        return "admin/list_all_products";
    }


    // Show all categories existing in DB paginated
    // ********************************************
    @GetMapping("/all_categories")
    public String getAllCategories(Model model) {
        model.addAttribute("all_product_categories", productCategoryService.findAlProductCategories());
        return getAllCategoriesByPage(model, 1, "categoryName", "asc");
    }

    @GetMapping("/all_categories/page/{pageNumber}")
    public String getAllCategoriesByPage(
            Model model,
            @PathVariable("pageNumber") int currentPage,
            @Param("sortField") String sortField,
            @Param("sortDirection") String sortDirection) {
        Page<ProductCategory> page = productCategoryService.findAllPageable(currentPage, sortField, sortDirection);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("all_categories", page.getContent());
        model.addAttribute("paginationLink", "/products/all_categories/page/");
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        String reverseSortDirection = sortDirection.equals("asc") ? "asc" : "desc";
        model.addAttribute("reverseSortDirection", reverseSortDirection);
        return "/admin/list_all_categories";
    }



}
