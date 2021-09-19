package com.example.store;

import com.example.store.product.Product;
import com.example.store.product.ProductRepository;
import com.example.store.product.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;


@SpringBootTest
public class productTest {


    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;


    @Test
    public void testProductCreationDate() {
        Product product = new Product();
        product.setProductPrice(23.3);
        product.setProductName("fruits");
        product.setProductQuantity(3);
        product.setProductDescription("fresh fruits");

        when(productRepository.save(ArgumentMatchers.any(Product.class))).then(returnsFirstArg());
        Product savedProduct = productService.saveProduct(product);

        assertThat(savedProduct.getProductCreatedAt()).isNotNull();
    }

    @Test
    public void testSaveOneProduct() {
        Product product = new Product();
        product.setProductDescription("milk is fine");
        product.setProductId(4);
        product.setProductPrice(34.4);
        product.setProductQuantity(3);
        product.setProductName("Milk");

        when(productRepository.save(ArgumentMatchers.any(Product.class))).then(returnsFirstArg());
        Product savedProduct = productService.saveProduct(product);

        Assertions.assertTrue(savedProduct.getProductId() > 0);

    }






}
