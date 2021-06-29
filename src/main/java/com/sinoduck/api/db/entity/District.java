package com.sinoduck.api.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author where.liu
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "district")
@EntityListeners(AuditingEntityListener.class)
public class District {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    @Version
    private Integer version;

    @JsonIgnore
    private LocalDateTime deletedAt;

    @JsonIgnore
    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
