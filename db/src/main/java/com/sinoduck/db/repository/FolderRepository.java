package com.sinoduck.db.repository;

import com.sinoduck.db.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author where.liu
 */
@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    Optional<Folder> findFirstByIdAndUserId(Long id, Long userId);

    Boolean existsByUserIdAndTitle(Long userId, String title);

    List<Folder> findAllByUserId(Long userId);

    /**
     * 删除指定用户的所有文件夹
     *
     * @param userId 用户ID
     */
    void deleteByUserId(Long userId);
}
