package com.rana.authservice.exception.handler;

import com.rana.authservice.exception.AuthException;
import com.rana.authservice.external.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> authErrorHandler(AuthException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ErrorResponse.builder()
                .errorCode(ex.getErrorCode()).errorMessage(ex.getMessage()).build());
    }

}
