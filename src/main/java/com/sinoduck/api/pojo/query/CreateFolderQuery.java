package com.sinoduck.api.pojo.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author where.liu
 */
@Data
public class CreateFolderQuery {
    @NotBlank(message = "名称不能为空")
    private String title;
}
