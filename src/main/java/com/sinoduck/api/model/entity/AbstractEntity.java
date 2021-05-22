package com.sinoduck.api.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author where.liu
 */
@Data
public abstract class AbstractEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    @Version
    private Integer version;
    @JsonIgnore
    @TableLogic
    private Date deletedAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;
    @TableField(fill = FieldFill.INSERT)
    private Date createdAt;
}
