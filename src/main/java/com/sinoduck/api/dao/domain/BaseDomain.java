package com.sinoduck.api.dao.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author where.liu
 */
@Data
public abstract class BaseDomain {
    @TableId
    private Long id;
    @Version
    private Integer version;
    @TableLogic
    private Date deletedAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;
    @TableField(fill = FieldFill.INSERT)
    private Date createdAt;
}
