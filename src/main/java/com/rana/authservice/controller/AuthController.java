package com.rana.authservice.controller;

import com.rana.authservice.external.request.RegisterUserRequest;
import com.rana.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("register-user")
    public void registerUser(@RequestBody RegisterUserRequest request) {
        authService.registerUser(request);
    }

}
