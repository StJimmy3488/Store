package com.example.store.cart_item;

import com.example.store.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemsByUser(User user) {
        return cartItemRepository.findByUser(user);
    }

//    public List<CartItem> getCartItemsByUsername(String userName) {
//        return cartItemRepository.findByUserName(userName);
//    }

    public List<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }

    public CartItem getById(Long cartItemId){
        return cartItemRepository.getById(cartItemId);
    }

    public void deleteCartItemById(Long cartItemId){
        cartItemRepository.deleteById(cartItemId);
    }

    public CartItem saveOrUpdateCartItem(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }
}
