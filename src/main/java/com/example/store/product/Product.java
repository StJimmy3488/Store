package com.example.store.product;

import com.example.store.cart_item.CartItem;
import com.example.store.order_item.OrderItem;
import com.example.store.product_image.ProductImage;
import com.example.store.user_review.UserReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false, unique = true)
    private long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_short_description", nullable = false)
    private String ProductDescription;

    @Column(name = "product_quantity", nullable = false)
    private Integer ProductQuantity;

    @Column(name = "product_price", nullable = false)
    private Double ProductPrice;

    @Column(name = "product_created_at")
    private LocalDate ProductCreatedAt;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<UserReview> userReviews = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductImage> productImages = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<OrderItem> orderItems = new ArrayList<>();





}
