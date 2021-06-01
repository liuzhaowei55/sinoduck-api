package com.sinoduck.api.model.entity;

import cn.hutool.crypto.digest.BCrypt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractEntity {
    private String username;
    @JsonIgnore
    private String password;
    private String nickname;
    private String avatar;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password);
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
}
