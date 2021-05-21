package com.sinoduck.api.dao.domain;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user")
public class UserDo extends BaseDomain {
    private String username;
    private String password;
    private String email;
    private String avatar;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password);
    }
}
