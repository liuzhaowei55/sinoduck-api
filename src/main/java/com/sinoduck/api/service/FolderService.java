package com.sinoduck.api.service;

import com.sinoduck.api.pojo.domain.FolderDO;
import com.sinoduck.api.pojo.domain.UserDO;
import com.sinoduck.api.repository.FolderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author where.liu
 */
@Service
public class FolderService {
    @Resource
    private FolderRepository folderRepository;

    public FolderDO createFolder(Long userId, String title) {
        FolderDO folderDO = new FolderDO();
        folderDO.setUserId(userId);
        folderDO.setTitle(title);
        return this.folderRepository.save(folderDO);
    }

    public List<FolderDO> listFolderRows(UserDO userDO) {
        return folderRepository.findAllByUserId(userDO.getId());
    }
}
