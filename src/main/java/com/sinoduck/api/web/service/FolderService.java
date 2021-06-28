package com.sinoduck.api.web.service;

import com.sinoduck.api.db.entity.Folder;
import com.sinoduck.api.db.entity.User;
import com.sinoduck.api.db.repository.FolderRepository;
import com.sinoduck.api.web.exception.ErrorResponseException;
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

    /**
     * 删除指定用户下的所有文件夹
     *
     * @param user 用户
     */
    public void delete(@NotNull User user) {
        this.folderRepository.deleteByUserId(user.getId());
    }
}
