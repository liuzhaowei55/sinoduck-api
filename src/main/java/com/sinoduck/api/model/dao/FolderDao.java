package com.sinoduck.api.model.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinoduck.api.model.entity.Folder;
import com.sinoduck.api.model.mapper.FolderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author where.liu
 */
@Service
public class FolderDao {
    @Resource
    private FolderMapper folderMapper;

    public Optional<Folder> findFirstByIdAndUserId(Long id, Long userId) {
        LambdaQueryWrapper<Folder> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Folder::getId, id);
        queryWrapper.eq(Folder::getUserId, userId);
        queryWrapper.last("LIMIT 1");
        return this.folderMapper.selectList(queryWrapper).stream().findFirst();
    }

    public Boolean existsByUserIdAndTitle(Long userid, String title) {
        LambdaQueryWrapper<Folder> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Folder::getUserId, userid);
        queryWrapper.eq(Folder::getTitle, title);
        queryWrapper.last("LIMIT 1");
        return this.folderMapper.selectCount(queryWrapper) > 0;
    }
}
