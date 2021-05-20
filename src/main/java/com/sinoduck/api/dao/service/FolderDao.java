package com.sinoduck.api.dao.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinoduck.api.dao.domain.FolderDo;
import com.sinoduck.api.dao.repository.FolderRepository;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author where.liu
 */
public class FolderDao {
    @Resource
    private FolderRepository folderRepository;

    public Optional<FolderDo> findFirstByIdAndUserId(Long id, Long userId) {
        LambdaQueryWrapper<FolderDo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(FolderDo::getId, id);
        queryWrapper.eq(FolderDo::getUserId, userId);
        FolderDo folderDo = folderRepository.getOne(queryWrapper, false);
        return Optional.of(folderDo);
    }

    public Boolean existsByUserIdAndTitle(Long userid, String title) {
        LambdaQueryWrapper<FolderDo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(FolderDo::getUserId, userid);
        queryWrapper.eq(FolderDo::getTitle, title);
        FolderDo folderDo = this.folderRepository.getOne(queryWrapper, false);
        return null!=folderDo;
    }
}
