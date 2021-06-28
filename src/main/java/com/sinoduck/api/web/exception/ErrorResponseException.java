package com.sinoduck.api.web.exception;

import com.sinoduck.api.web.dto.ResponseDTO;
import lombok.Getter;

/**
 * @author where.liu
 */
public class ErrorResponseException extends Exception {
    @Getter
    private final ResponseDTO responseDTO;

    public ErrorResponseException(CustomErrorEnum customErrorEnum) {
        this.responseDTO = ResponseDTO.builder()
                .code(customErrorEnum.getCode())
                .message(customErrorEnum.getMessage())
                .build();

    }

    public ErrorResponseException(ResponseDTO responseDTO) {
        this.responseDTO = responseDTO;
    }

    public ErrorResponseException(String code, String message) {
        this.responseDTO = ResponseDTO.builder()
                .code(code)
                .message(message)
                .build();

    }
}

