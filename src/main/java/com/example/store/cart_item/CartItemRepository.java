package com.example.store.cart_item;

import com.example.store.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    public List<CartItem> findByUser(User user);

//    @Query("SELECT userId FROM CartItem u WHERE u.userName = :userName")
//    public List<CartItem> findByUserName(String userName);

}
