package com.sinoduck.api.pojo.query;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author where.liu
 */
@Data
public class CreateFolderQuery {
    @NotEmpty(message = "名称不能为空")
    private String title;
}
