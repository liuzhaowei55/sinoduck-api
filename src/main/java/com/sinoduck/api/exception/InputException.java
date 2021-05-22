package com.sinoduck.api.exception;

import com.sinoduck.api.pojo.dto.ResponseDTO;
import lombok.Getter;

/**
 * @author where.liu
 */
public class InputException extends Exception {
    @Getter
    private String field;
    @Getter
    private String[] messages;

    public InputException(String field, String message) {
        this.field = field;
        this.messages = new String[]{message};
    }

    public InputException(String field, String[] messages) {
        this.field = field;
        this.messages = messages;
    }
}
