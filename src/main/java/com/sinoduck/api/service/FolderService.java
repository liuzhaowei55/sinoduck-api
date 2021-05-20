package com.sinoduck.api.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinoduck.api.dao.domain.FolderDo;
import com.sinoduck.api.dao.domain.UserDo;
import com.sinoduck.api.dao.mapper.FolderMapper;
import com.sinoduck.api.dao.service.FolderDao;
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

    public FolderDo createFolder(@NotNull UserDo userDO, @NotBlank String title) throws ErrorResponseException {
        if (folderDao.existsByUserIdAndTitle(userDO.getId(), title)) {
            throw new ErrorResponseException("B0000", "文件夹名称已存在");
        }
        FolderDo folderDO = new FolderDo();
        folderDO.setUserId(userDO.getId());
        folderDO.setTitle(title);
        this.folderMapper.insert(folderDO);
        return folderDO;
    }

    public List<FolderDo> listFolderRows(@NotNull UserDo userDO) {
        LambdaQueryWrapper<FolderDo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(FolderDo::getUserId, userDO.getId());
        return this.folderMapper.selectList(queryWrapper);
    }

    public void update(UpdateWrapper<FolderDo> updateWrapper) {
        this.folderMapper.update(null, updateWrapper);
    }
}
