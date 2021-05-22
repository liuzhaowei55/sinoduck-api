package com.sinoduck.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author where.liu
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {
    @Basic
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Version
    private Integer version;
    @Basic
    @JsonIgnore
    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private Date updatedAt;
    @Basic
    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;
}
