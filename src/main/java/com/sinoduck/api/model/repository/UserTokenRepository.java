package com.sinoduck.api.model.repository;

import com.sinoduck.api.model.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author where.liu
 */
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {
    Optional<UserToken> findFirstByAccessToken(String accessToken);
}
