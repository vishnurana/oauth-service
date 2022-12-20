package com.rana.authservice.service;

import com.rana.authservice.entity.User;
import com.rana.authservice.exception.UserException;
import com.rana.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        user.setUsername(user.getUsername().toLowerCase());
        return userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username.toLowerCase())
                .orElseThrow(() -> UserException.userNotFound(username));
    }

    public void isUsernameAvailable(String username) {
        if (userRepository.existsByUsername(username.toLowerCase())) {
            throw UserException.usernameAlreadyTaken(username);
        }
    }

    public void isEmailAvailable(String email) {
        if (userRepository.existsByEmail(email.toLowerCase())) {
            throw UserException.emailAlreadyTaken(email);
        }
    }

}
