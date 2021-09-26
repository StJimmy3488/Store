package com.example.store.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CartService {

    private final CartRepository cartRepository;

    public Cart saveOrUpdateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.getById(cartId);
    }
}


