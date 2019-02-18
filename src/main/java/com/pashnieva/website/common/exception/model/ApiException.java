package com.pashnieva.website.common.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Data
@AllArgsConstructor
public class ApiException extends RuntimeException {

    private HttpStatus httpStatus;
    private String code;
    private String message;

    public static ApiException notFound(String code, String message) {
        return new ApiException(NOT_FOUND, code, message);
    }

    public static ApiException badRequest(String code, String message) {
        return new ApiException(BAD_REQUEST, code, message);
    }

    public static ApiException forbidden(String code, String message) {
        return new ApiException(FORBIDDEN, code, message);
    }

    public static ApiException unauthorized(String code, String message) {
        return new ApiException(UNAUTHORIZED, code, message);
    }

    public static ApiException unprocessableEntity(String code, String message) {
        return new ApiException(UNPROCESSABLE_ENTITY, code, message);
    }

    public static ApiException internalServerError(String code, String message) {
        return new ApiException(INTERNAL_SERVER_ERROR, code, message);
    }
}
