package com.sinoduck.api.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime deletedAt;
    @Basic
    @JsonIgnore
    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime updatedAt;
    @Basic
    @JsonIgnore
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
