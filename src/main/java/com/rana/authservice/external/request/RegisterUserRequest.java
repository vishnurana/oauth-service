package com.rana.authservice.external.request;

import lombok.Getter;

@Getter
public class RegisterUserRequest {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
