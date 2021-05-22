package com.sinoduck.api.model.entity;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user")
public class User extends AbstractEntity {
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String avatar;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password);
    }
}
