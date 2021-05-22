package com.sinoduck.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "folder")
public class Folder extends AbstractEntity {
    private Long userId;
    private String title;
}
