package com.sinoduck.api.module.user.db.repository;

import com.sinoduck.api.module.user.db.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author where.liu
 */
@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {
    Optional<UserToken> findFirstByAccessToken(String accessToken);
}
