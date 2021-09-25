package com.example.store.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User saveOrUpdateUser(User user) {
        var existingUser = userRepository.findByUserEmail(user.getUserEmail());
        if (existingUser.isPresent()) {
            System.out.printf("\u001B[31m" + " User with email %s \u001B[0m %n", user.getUserEmail());
            throw new RuntimeException(String.format("User with email %s exist", user.getUserEmail()));
        }
        user.setUserCreatedAt(LocalDate.now());
        return userRepository.save(user);
    }


    public List<User> findAllUsers(Pageable pageable) {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User getById(Long id) {
        var userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        }

        System.out.printf("\u001B[31m" + " User with id %d  does not exist \u001B[0m %n", id);
        return null;
    }
}

