package com.rana.authservice.transformer;

import com.rana.authservice.entity.User;
import com.rana.authservice.external.request.RegisterUserRequest;

public class UserTransformer {

    public static User toEntity(RegisterUserRequest request) {
        return User.builder().username(request.getUsername()).email(request.getEmail())
                .firstName(request.getFirstName()).lastName(request.getLastName()).build();
    }

}
