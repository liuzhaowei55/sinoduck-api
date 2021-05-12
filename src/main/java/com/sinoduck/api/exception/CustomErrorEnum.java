package com.sinoduck.api.exception;

import lombok.Getter;

/**
 * @author where.liu
 */
@Getter
public enum CustomErrorEnum {
    /**
     * 全局信息中无法读取到当前登录用户
     */
    CURRENT_USER_NOT_FOUND("A0001", "未登录");
    private final String code;
    private final String message;

    CustomErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
