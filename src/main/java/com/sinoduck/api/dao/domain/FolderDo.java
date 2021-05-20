package com.sinoduck.api.dao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "folder")
public class FolderDo extends BaseDomain {
    private Long userId;
    private String title;
}
