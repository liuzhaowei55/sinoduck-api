package com.sinoduck.api.portal.pojo.query;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author where.liu
 */
@Data
public class UserLoginQuery {
    @NotNull
    @Length(min = 3, max = 16)
    private String username;
    @NotNull
    @Length(min = 6)
    private String password;
}
