package com.sinoduck.api.pojo.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
@DynamicInsert
@DynamicUpdate
@Table(name = "folder")
@EntityListeners(AuditingEntityListener.class)
public class FolderDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;
    @Version
    private Integer version;
    private Date deletedAt;
    @LastModifiedDate
    private Date updatedAt;
    @CreatedDate
    private Date createdAt;
}
