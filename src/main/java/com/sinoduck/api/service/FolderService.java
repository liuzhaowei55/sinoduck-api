package com.sinoduck.api.service;

import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.pojo.domain.FolderDO;
import com.sinoduck.api.pojo.domain.UserDO;
import com.sinoduck.api.repository.FolderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author where.liu
 */
@Service
public class FolderService {
    @Resource
    private FolderRepository folderRepository;

    public FolderDO createFolder(@NotNull UserDO userDO, @NotBlank String title) throws ErrorResponseException {
        if (folderRepository.existsByUserIdAndTitle(userDO.getId(), title)) {
            throw new ErrorResponseException("B0000", "文件夹名称已存在");
        }
        FolderDO folderDO = new FolderDO();
        folderDO.setUserId(userDO.getId());
        folderDO.setTitle(title);
        return this.folderRepository.save(folderDO);
    }

    public List<FolderDO> listFolderRows(@NotNull UserDO userDO) {
        return folderRepository.findAllByUserId(userDO.getId());
    }

    public void update(@NotNull FolderDO folderDO) {
        this.folderRepository.save(folderDO);
    }
}
