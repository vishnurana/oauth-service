package com.rana.authservice.exception;

import com.rana.authservice.exception.errors.AuthErrors;
import com.rana.authservice.exception.errors.UserErrors;
import org.springframework.http.HttpStatus;

public class UserException extends AuthException {

    public UserException(AuthErrors authErrors, Object... args) {
        super(authErrors, args);
    }

    public UserException(HttpStatus httpStatus, AuthErrors authErrors, Object... args) {
        super(httpStatus, authErrors, args);
    }

    public static UserException userNotFound(String username) {
        return new UserException(HttpStatus.BAD_REQUEST, UserErrors.USER_NOT_FOUND, username);
    }

    public static UserException usernameAlreadyTaken(String username) {
        return new UserException(HttpStatus.BAD_REQUEST, UserErrors.USERNAME_TAKEN, username);
    }

    public static UserException emailAlreadyTaken(String email) {
        return new UserException(HttpStatus.BAD_REQUEST, UserErrors.EMAIL_TAKEN, email);
    }
}
