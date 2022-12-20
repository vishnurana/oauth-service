package com.rana.authservice.service;

import com.rana.authservice.entity.User;
import com.rana.authservice.external.request.RegisterUserRequest;
import com.rana.authservice.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public void registerUser(RegisterUserRequest request) {
        userService.isUsernameAvailable(request.getUsername());
        userService.isEmailAvailable(request.getEmail());
        User userEntity = UserTransformer.toEntity(request);
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userService.save(userEntity);
    }

}
