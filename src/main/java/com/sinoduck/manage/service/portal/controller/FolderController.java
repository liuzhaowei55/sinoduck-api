package com.sinoduck.manage.service.portal.controller;

import com.sinoduck.api.db.entity.Folder;
import com.sinoduck.manage.service.exception.ErrorResponseException;
import com.sinoduck.manage.service.pojo.dto.ResponseDTO;
import com.sinoduck.manage.service.portal.pojo.converter.FolderDtoConverter;
import com.sinoduck.manage.service.portal.pojo.dto.FolderDTO;
import com.sinoduck.manage.service.portal.pojo.query.FolderCreateQuery;
import com.sinoduck.manage.service.portal.logic.FolderLogic;
import com.sinoduck.manage.service.portal.pojo.query.FolderUpdateQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Folder> folderList = folderLogic.listFolders();
        List<FolderDTO> folderDTOList = folderList.stream().map(FolderDtoConverter.INSTANCE::fromFolderDO).collect(Collectors.toList());
        return ResponseDTO.success(folderDTOList);
    }

    /**
     * 创建文件夹
     *
     * @param param 文件夹参数
     */
    @PostMapping(value = "add")
    public ResponseDTO create(FolderCreateQuery param) throws ErrorResponseException {
        Folder folder = folderLogic.addFolder(param.getTitle());
        log.error("folder: {}", folder);
        return ResponseDTO.success(FolderDtoConverter.INSTANCE.fromFolderDO(folder));
    }

    @PostMapping(value = "update")
    public ResponseDTO update(FolderUpdateQuery query) throws ErrorResponseException {
        Folder folder = this.folderLogic.updateFolder(query.getId(), query.getTitle());
        return ResponseDTO.success(folder);
    }
}
