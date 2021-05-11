package com.sinoduck.api.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author where.liu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String code;
    private String message;
    private Object data;

    public static ResponseDTO success() {
        return ResponseDTO.builder()
                .code("00000")
                .message("OK")
                .build();
    }

    public static ResponseDTO success(Object data) {
        return ResponseDTO.builder()
                .code("00000")
                .message("OK")
                .data(data)
                .build();
    }
}
