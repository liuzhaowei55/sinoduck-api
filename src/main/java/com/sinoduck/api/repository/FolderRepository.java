package com.sinoduck.api.repository;

import com.sinoduck.api.pojo.domain.FolderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author where.liu
 */
@Repository
public interface FolderRepository extends CrudRepository<FolderDO, Long> {

    /**
     * 查询用户的文件夹列表
     *
     * @param userId 用户 ID
     * @return 文件夹列表
     */
    List<FolderDO> findAllByUserId(Long userId);

    /**
     * 查找用户指定文件夹
     *
     * @param id     文件夹 ID
     * @param userId 用户 ID
     * @return 文件夹
     */
    Optional<FolderDO> findFirstByIdAndUserId(Long id, Long userId);

    /**
     * 判断是否存在同名文件夹
     *
     * @param userId 用户 ID
     * @param title  文件夹名称
     * @return true 存在
     */
    Boolean existsByUserIdAndTitle(Long userId, String title);
}
