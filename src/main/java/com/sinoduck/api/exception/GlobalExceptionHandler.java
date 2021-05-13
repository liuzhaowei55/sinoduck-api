package com.sinoduck.api.exception;

import com.sinoduck.api.pojo.dto.ResponseDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author where.liu
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ErrorResponseException.class)
    public ResponseDTO errorResponseExceptionHandler(ErrorResponseException exception) {
        return exception.getResponseDTO();
    }
}
