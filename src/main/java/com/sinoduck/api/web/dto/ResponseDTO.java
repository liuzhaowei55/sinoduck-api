package com.sinoduck.api.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
