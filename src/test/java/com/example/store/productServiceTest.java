package com.example.store;

import com.example.store.product.Product;
import com.example.store.product.ProductRepository;
import com.example.store.product.ProductService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class productServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    @Test
    public void testProductCreationDate() {
        Product product = new Product();

        when(productRepository.save(ArgumentMatchers.any(Product.class))).then(returnsFirstArg());
        Product savedProduct = productService.saveOrUpdateProduct(product);

        assertThat(savedProduct.getProductCreatedAt()).isNotNull();
    }

    @Test
    public void testSaveOneProduct() {
        Product product = new Product();

        when(productRepository.save(ArgumentMatchers.any(Product.class))).then(returnsFirstArg());
        Product savedProduct = productService.saveOrUpdateProduct(product);

        Assertions.assertEquals(savedProduct, product);

    }

    @Test
    public void testFindAllProducts() {
        Product product = new Product();
        Product product1 = new Product();

        List<Product> products = Arrays.asList(product, product1);

        when(productRepository.findAll()).thenReturn(products);
        List<Product> result = productService.findAllProducts();

        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
    }

    @Test
    public void testFindProductByName() {
        Product product = new Product();
        product.setProductName("first");

        when(productRepository.findProductByProductName("first")).thenReturn(Optional.of(product));
        Optional<Product> result = productService.findByProductName("first");
        assertThat(result.get().getProductName()).isEqualTo("first");

//        String name = "name";
//        productService.findByProductName(name);
//        verify(productRepository).findProductByProductName(eq(name));  // also works
    }

    @Test
    public void testDeleteProductById() {
        Long testId = 23L;

        productService.deleteProductById(testId);
        verify(productRepository).deleteById(eq(testId));
    }


}
