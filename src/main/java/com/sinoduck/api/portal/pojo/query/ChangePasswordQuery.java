package com.sinoduck.api.portal.pojo.query;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author where.liu
 */
@Data
public class ChangePasswordQuery {
    @NotNull
    @Length(min = 6, message = "密码最少为 6 位")
    private String oldPassword;
    @NotNull
    @Length(min = 6, message = "密码最少为 6 位")
    private String newPassword;
    @NotNull
    @Length(min = 6, message = "密码最少为 6 位")
    private String newPasswordConfirmation;
}
