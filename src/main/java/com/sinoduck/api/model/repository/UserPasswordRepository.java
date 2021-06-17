package com.sinoduck.api.model.repository;

import com.sinoduck.api.model.entity.UserPassword;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author where.liu
 */
public interface UserPasswordRepository extends JpaRepository<UserPassword, Long> {
    /**
     * 查询用户最后一个未删除的密码
     *
     * @param userId 用户 ID
     * @return 记录
     */
    Optional<UserPassword> findFirstByUserIdAndDeletedAtNullOrderByIdDesc(Long userId);

    /**
     * 软删除
     *
     * @param userPassword 待删除的实体
     */
    default void softDelete(UserPassword userPassword) {
        userPassword.setExpiredAt(LocalDateTime.now());
        this.save(userPassword);
    }
}
