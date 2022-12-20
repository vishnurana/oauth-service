package com.rana.authservice.exception;

import com.rana.authservice.exception.errors.AuthErrors;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;
import java.util.Arrays;

@Getter
public class AuthException extends RuntimeException {

    private int errorCode;
    private HttpStatus httpStatus;

    public AuthException(String message) {
        super(message);
    }

    public AuthException(AuthErrors authErrors, Object... args) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, authErrors, args);
    }

    public AuthException(HttpStatus httpStatus, AuthErrors authErrors, Object... args) {
        this(MessageFormat.format(authErrors.getErrorMessage(),
                Arrays.stream(args).map(Object::toString).toArray()));
        this.httpStatus = httpStatus;
        this.errorCode = authErrors.getErrorCode();
    }

}
