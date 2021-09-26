package com.example.store.cart_item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public List<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }

    public CartItem getById(Long cartItemId){
        return cartItemRepository.getById(cartItemId);
    }

    public void deleteById(Long cartItemId){
        cartItemRepository.deleteById(cartItemId);
    }
}
