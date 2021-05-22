package com.sinoduck.api.exception;

import com.sinoduck.api.pojo.dto.ResponseDTO;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

/**
 * @author where.liu
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ErrorResponseException.class)
    public ResponseDTO errorResponseExceptionHandler(ErrorResponseException exception) {
        return exception.getResponseDTO();
    }

    @ExceptionHandler(BindException.class)
    public ResponseDTO bindException(BindException exception) {
        Map<String, List<String>> errors = new HashMap<>(exception.getErrorCount());
        for (FieldError error : exception.getFieldErrors()) {
            if (errors.containsKey(error.getField())) {
                List<String> errorMessageList = errors.get(error.getField());
                errorMessageList.add(error.getDefaultMessage());
                errors.put(error.getField(), errorMessageList);
            } else {
                List<String> errorMessageList = new ArrayList<>();
                errorMessageList.add(error.getDefaultMessage());
                errors.put(error.getField(), errorMessageList);
            }
        }
        return ResponseDTO.builder().code("A0000").message("INPUT ERROR").data(errors).build();
    }

    @ExceptionHandler(InputException.class)
    public ResponseDTO inputException(InputException exception) {
        Map<String, List<String>> errors = new HashMap<>(1);
        errors.put(exception.getField(), List.of(exception.getMessages()));
        return ResponseDTO.builder().code("A0000").message("INPUT ERROR").data(errors).build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseDTO httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return ResponseDTO.builder().code("A0000").message("INPUT ERROR").build();
    }
}
