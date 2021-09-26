package com.example.store.cart;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class CartService {

    private final CartRepository cartRepository;

    public Cart saveOrUpdateCart (Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> findAllCarts() { return cartRepository.findAll(); }

    public Cart findById(Long cartId) { return cartRepository.findById(); }

    }


