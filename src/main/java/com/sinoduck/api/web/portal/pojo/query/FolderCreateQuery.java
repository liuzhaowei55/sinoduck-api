package com.sinoduck.api.web.portal.pojo.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author where.liu
 */
@Data
public class FolderCreateQuery {
    @NotBlank(message = "名称不能为空")
    private String title;
}
