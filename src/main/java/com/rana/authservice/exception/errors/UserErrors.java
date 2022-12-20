package com.rana.authservice.exception.errors;

import lombok.Getter;

@Getter
public enum UserErrors implements AuthErrors {

    USER_NOT_FOUND(1000, "user not found for username {0}"),
    USERNAME_TAKEN(1001, "username ({0}) is already taken"),
    EMAIL_TAKEN(1002, "email ({0}) is already taken");

    final int errorCode;
    final String errorMessage;

    UserErrors(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
