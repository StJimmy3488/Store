package com.example.store.product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    // Show all trips existing in DB paginated
    @GetMapping("/all_products")
    public String getAllProducts(Model model) {
        return getAllProductsByPage(model, 1);
    }

    @GetMapping("/all_products/page/{pageNumber}")
    public String getAllProductsByPage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<Product> page = productService.findAllPagable(currentPage);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("all_products", page.getContent());
        model.addAttribute("paginationLink", "/products/all_products/page/");
        return "/products/all_products";
    }

}
