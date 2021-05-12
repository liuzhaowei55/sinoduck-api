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
@Data
@Entity
@Table(name = "user")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
    private Date deletedAt;
    @LastModifiedDate
    private Date updatedAt;
    @CreatedDate
    private Date createdAt;
}
