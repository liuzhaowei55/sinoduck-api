package com.sinoduck.manage.service.portal.pojo.query;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class DeleteUserQuery {
    @NotNull(message = "密码不能为空")
    @Length(min = 6, message = "密码最短为 6 位")
    private String password;
}
