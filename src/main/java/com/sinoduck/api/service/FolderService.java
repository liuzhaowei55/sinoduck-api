package com.sinoduck.api.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinoduck.api.model.entity.Folder;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.mapper.FolderMapper;
import com.sinoduck.api.model.dao.FolderDao;
import com.sinoduck.api.exception.ErrorResponseException;
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
    private FolderMapper folderMapper;
    @Resource
    private FolderDao folderDao;

    public Folder createFolder(@NotNull User user, @NotBlank String title) throws ErrorResponseException {
        if (folderDao.existsByUserIdAndTitle(user.getId(), title)) {
            throw new ErrorResponseException("B0000", "文件夹名称已存在");
        }
        Folder folder = new Folder();
        folder.setUserId(user.getId());
        folder.setTitle(title);
        this.folderMapper.insert(folder);
        return folder;
    }

    public List<Folder> listFolderRows(@NotNull User user) {
        LambdaQueryWrapper<Folder> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Folder::getUserId, user.getId());
        return this.folderMapper.selectList(queryWrapper);
    }

    public void update(UpdateWrapper<Folder> updateWrapper) {
        this.folderMapper.update(null, updateWrapper);
    }
}
