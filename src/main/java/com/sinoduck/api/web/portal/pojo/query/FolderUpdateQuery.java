package com.sinoduck.api.web.portal.pojo.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author where.liu
 */
@Data
public class FolderUpdateQuery {
    @NotEmpty
    private Long id;
    @NotBlank
    private String title;
}
