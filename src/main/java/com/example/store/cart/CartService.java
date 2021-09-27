package com.example.store.cart;

import com.example.store.cart_item.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public Cart saveOrUpdateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.getById(cartId);
    }

    public Long getBySessionId(String sessionId) {
        return cartRepository.findBySessionId(sessionId);
    }
}


