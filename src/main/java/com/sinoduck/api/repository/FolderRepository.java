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
     * 更新标题
     *
     * @param id    folder id
     * @param title 标题
     */
    @Modifying
    @Transactional
    @Query("update FolderDO set title = ?2 where id = ?1")
    void updateTitleById(Long id, String title);

    /**
     * 查找用户指定文件夹
     *
     * @param id     文件夹 ID
     * @param userId 用户 ID
     * @return 文件夹
     */
    Optional<FolderDO> findFirstByIdAndUserId(Long id, Long userId);
}
