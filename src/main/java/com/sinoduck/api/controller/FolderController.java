package com.sinoduck.api.controller;

import com.sinoduck.api.pojo.dto.ResponseDTO;
import com.sinoduck.api.pojo.query.CreateFolderQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author where.liu
 */
@RestController
@RequestMapping(value = "/folder")
@Slf4j
public class FolderController {
    /**
     * 创建文件夹
     *
     * @param param 文件夹参数
     */
    @PostMapping()
    public ResponseDTO create(CreateFolderQuery param) {
        log.info("param {}", param);
        return ResponseDTO.success();
    }
}
