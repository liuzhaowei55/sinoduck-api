package com.sinoduck.manage.service.portal.pojo.query;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author where.liu
 */
@Data
@NotNull
public class CreateUserQuery {
    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 16)
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6)
    private String password;

    @NotBlank(message = "确认密码不能为空")
    @Length(min = 6)
    private String passwordConfirmation;
}
