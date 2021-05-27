package com.sinoduck.api.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 登录凭证
 *
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "token")
@EntityListeners(AuditingEntityListener.class)
public class Token extends AbstractEntity {
    private Long userId;
    private String accessToken;
    private String ua;
    private String ip;
}
