package com.sinoduck.api.portal.controller;

import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.pojo.domain.FolderDO;
import com.sinoduck.api.pojo.dto.ResponseDTO;
import com.sinoduck.api.portal.pojo.query.FolderCreateQuery;
import com.sinoduck.api.portal.logic.FolderLogic;
import com.sinoduck.api.portal.pojo.query.FolderUpdateQuery;
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
    @PostMapping(value = "add")
    public ResponseDTO create(FolderCreateQuery param) throws ErrorResponseException {
        FolderDO folderDO = folderLogic.addFolder(param.getTitle());
        return ResponseDTO.success(folderDO);
    }

    @PostMapping(value = "update")
    public ResponseDTO update(FolderUpdateQuery query) throws ErrorResponseException {
        FolderDO folderDO = this.folderLogic.updateFolder(query.getId(), query.getTitle());
        return ResponseDTO.success(folderDO);
    }
}
