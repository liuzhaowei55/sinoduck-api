package com.sinoduck.api.portal.logic;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinoduck.api.dao.domain.FolderDo;
import com.sinoduck.api.dao.domain.UserDo;
import com.sinoduck.api.dao.repository.FolderRepository;
import com.sinoduck.api.dao.service.FolderDao;
import com.sinoduck.api.exception.CustomErrorEnum;
import com.sinoduck.api.exception.ErrorResponseException;
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

    @Resource
    private FolderDao folderDao;

    @Resource
    private FolderRepository folderRepository;

    public List<FolderDo> listFolders() throws ErrorResponseException {
        UserDo userDO = ThreadGlobalInfoContextHolder.getUser();
        if (null==userDO) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        return folderService.listFolderRows(userDO);
    }

    public FolderDo addFolder(String title) throws ErrorResponseException {
        UserDo userDO = ThreadGlobalInfoContextHolder.getUser();
        if (null==userDO) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        return folderService.createFolder(userDO, title);
    }

    public FolderDo updateFolder(Long id, String title) throws ErrorResponseException {
        UserDo userDO = ThreadGlobalInfoContextHolder.getUser();
        if (null==userDO) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        Optional<FolderDo> optionalFolderDO = this.folderDao.findFirstByIdAndUserId(id, userDO.getId());
        if (optionalFolderDO.isEmpty()) {
            throw new ErrorResponseException("A0000", "文件夹不存在");
        }
        FolderDo folderDO = optionalFolderDO.get();


        LambdaUpdateWrapper<FolderDo> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(FolderDo::getId, folderDO.getId());
        updateWrapper.set(FolderDo::getTitle, title);
        if (this.folderRepository.update(updateWrapper)) {
            folderDO.setTitle(title);
        }

        return folderDO;
    }
}
