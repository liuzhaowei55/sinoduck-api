package com.sinoduck.api.portal.logic;

import com.sinoduck.api.exception.CustomErrorEnum;
import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.pojo.domain.FolderDO;
import com.sinoduck.api.pojo.domain.UserDO;
import com.sinoduck.api.service.FolderService;
import com.sinoduck.api.util.ThreadGlobalInfoContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author where.liu
 */
@Service
public class FolderLogic {
    @Resource
    private FolderService folderService;

    public List<FolderDO> listFolders() throws ErrorResponseException {
        UserDO userDO = ThreadGlobalInfoContextHolder.getUser();
        if (null==userDO) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        return folderService.listFolderRows(userDO);
    }
}
