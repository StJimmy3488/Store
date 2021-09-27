package com.example.store.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM User u WHERE u.UserEmail = ?1")
    Optional<User> findByUserEmail(String email);

    Optional<User> findByUsernameIgnoreCase(String username);

    boolean existsByUsername(String username);
}
