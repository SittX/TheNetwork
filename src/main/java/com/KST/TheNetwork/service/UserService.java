package com.KST.TheNetwork.service;

import com.KST.TheNetwork.model.User;
import com.KST.TheNetwork.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        if (user == null) throw new RuntimeException("User cannot be null");

        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
