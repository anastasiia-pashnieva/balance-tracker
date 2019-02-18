package com.pashnieva.website.common.exception.ws;

import com.pashnieva.website.common.exception.model.ApiException;
import com.pashnieva.website.common.exception.model.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<ExceptionResponse> handleApiException(ApiException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getCode(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, ex.getHttpStatus());
    }
}
