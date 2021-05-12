package com.sinoduck.api.repository;

import com.sinoduck.api.pojo.domain.FolderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author where.liu
 */
@Repository
public interface FolderRepository extends JpaRepository<FolderDO, Long> {

    /**
     * 查询用户的文件夹列表
     *
     * @param userId 用户 ID
     * @return 文件夹列表
     */
    List<FolderDO> findAllByUserId(Long userId);
}
