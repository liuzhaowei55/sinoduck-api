package com.sinoduck.api.service;

import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.model.entity.Folder;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.repository.FolderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author where.liu
 */
@Service
public class FolderService {
    @Resource
    private FolderRepository folderRepository;

    public Folder createFolder(@NotNull User user, @NotBlank String title) throws ErrorResponseException {
        if (folderRepository.existsByUserIdAndTitle(user.getId(), title)) {
            throw new ErrorResponseException("B0000", "文件夹名称已存在");
        }
        Folder folder = new Folder();
        folder.setUserId(user.getId());
        folder.setTitle(title);
        return this.folderRepository.saveAndFlush(folder);
    }
}
