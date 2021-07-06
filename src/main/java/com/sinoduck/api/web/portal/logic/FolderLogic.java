package com.sinoduck.api.web.portal.logic;

import com.sinoduck.api.db.entity.Folder;
import com.sinoduck.api.module.user.db.entity.User;
import com.sinoduck.api.db.repository.FolderRepository;
import com.sinoduck.api.web.exception.CustomErrorEnum;
import com.sinoduck.api.web.exception.ErrorResponseException;
import com.sinoduck.api.web.service.FolderService;
import com.sinoduck.api.web.util.ThreadGlobalInfoContextHolder;
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
    private FolderRepository folderRepository;

    public List<Folder> listFolders() throws ErrorResponseException {
        User user = ThreadGlobalInfoContextHolder.getUser();
        if (null==user) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        return folderRepository.findAllByUserId(user.getId());
    }

    public Folder addFolder(String title) throws ErrorResponseException {
        User user = ThreadGlobalInfoContextHolder.getUser();
        if (null==user) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        return folderService.createFolder(user, title);
    }

    public Folder updateFolder(Long id, String title) throws ErrorResponseException {
        User user = ThreadGlobalInfoContextHolder.getUser();
        if (null==user) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        Optional<Folder> optionalFolderDO = this.folderRepository.findFirstByIdAndUserId(id, user.getId());
        if (optionalFolderDO.isEmpty()) {
            throw new ErrorResponseException("A0000", "文件夹不存在");
        }
        Folder folder = optionalFolderDO.get();
        folder.setTitle(title);
        return this.folderRepository.save(folder);
    }
}
