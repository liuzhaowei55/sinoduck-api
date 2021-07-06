package com.sinoduck.api.module.user.db.repository;

import com.sinoduck.api.module.user.db.entity.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author where.liu
 */
@Repository
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
