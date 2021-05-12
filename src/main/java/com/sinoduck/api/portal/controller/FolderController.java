package com.sinoduck.api.portal.controller;

import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.pojo.dto.ResponseDTO;
import com.sinoduck.api.pojo.query.CreateFolderQuery;
import com.sinoduck.api.portal.logic.FolderLogic;
import com.sinoduck.api.service.FolderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author where.liu
 */
@RestController
@RequestMapping(value = "/folder")
@Slf4j
public class FolderController {
    @Resource
    private FolderService folderService;
    @Resource
    private FolderLogic folderLogic;

    @GetMapping(value = "list")
    public ResponseDTO list() throws ErrorResponseException {
        return ResponseDTO.success(folderLogic.listFolders());
    }

    /**
     * 创建文件夹
     *
     * @param param 文件夹参数
     */
    @PostMapping()
    public ResponseDTO create(CreateFolderQuery param) {
        this.folderService.createFolder(1L, param.getTitle());
        return ResponseDTO.success();
    }
}
