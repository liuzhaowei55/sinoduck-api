package com.sinoduck.api.model.repository;

import com.sinoduck.api.model.entity.Folder;
import com.sinoduck.api.model.entity.User;
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

    Boolean existsByUserAndTitle(User user, String title);

    List<Folder> findAllByUserId(Long userId);
}
