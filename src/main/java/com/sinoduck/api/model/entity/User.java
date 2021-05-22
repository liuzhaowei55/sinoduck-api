package com.sinoduck.api.model.entity;

import cn.hutool.crypto.digest.BCrypt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author where.liu
 */
@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String avatar;
    @Version
    private Integer version;
    @JsonIgnore
    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private Date updatedAt;
    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password);
    }
}
