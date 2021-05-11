package com.sinoduck.api.pojo.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.util.Date;

/**
 * @author where.liu
 */
@Entity
@Data
@Table(name = "folder")
public class FolderDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer userId;
    private String title;
    @Version
    private Integer version;
    private Date deletedAt;
    @LastModifiedDate
    private Date updatedAt;
    @CreatedDate
    private Date createdAt;
}
