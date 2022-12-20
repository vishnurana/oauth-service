package com.rana.authservice.external.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private Integer errorCode;
    private String errorMessage;

}
