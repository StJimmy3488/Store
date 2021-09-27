package com.example.store.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT s.cartId from Cart s where s.sessionId = :sessionId")
    Long findBySessionId(@Param("sessionId") String sessionId);

}