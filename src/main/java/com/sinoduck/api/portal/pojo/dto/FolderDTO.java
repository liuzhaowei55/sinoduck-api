package com.sinoduck.api.portal.pojo.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author where.liu
 */
@Data
public class FolderDTO {
    private Long id;
    private String title;
    private Date createdAt;
}
