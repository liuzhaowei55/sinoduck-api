package com.sinoduck.api.db.entity;

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
import java.time.LocalDateTime;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "user_password")
@EntityListeners(AuditingEntityListener.class)
public class UserPassword extends AbstractEntity {
    private Long userId;
    @JsonIgnore
    private String password;
    private LocalDateTime expiredAt;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password);
    }
}
