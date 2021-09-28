package com.example.store.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    public User getUserByUserName(@Param("userName") String userName);

    @Query("SELECT u FROM User u WHERE u.userEmail = ?1")
    Optional<User> findByUserEmail(String email);

    boolean existsByUserName(String userName);
}
