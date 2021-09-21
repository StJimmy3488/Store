package com.example.store.cart_item;

import com.example.store.cart.Cart;
import com.example.store.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_item_id", nullable = false, unique = true)
    private Long cartItemId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "cart_item_created_at", nullable = false)
    private LocalDate cartItemCreatedAt;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
