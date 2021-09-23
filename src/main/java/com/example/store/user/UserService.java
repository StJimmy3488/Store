package com.example.store.user;

import com.example.store.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User saveOrUpdateUser(User user) {
        user.setUserCreatedAt(LocalDate.now());
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById (Long id) {
        userRepository.deleteById(id);
    }



}

