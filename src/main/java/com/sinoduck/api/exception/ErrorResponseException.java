package com.sinoduck.api.exception;

import lombok.Getter;

/**
 * @author where.liu
 */
public class ErrorResponseException extends Exception {
    @Getter
    private final CustomErrorEnum customErrorEnum;

    public ErrorResponseException(CustomErrorEnum customErrorEnum) {
        this.customErrorEnum = customErrorEnum;
    }
}

