package com.sinoduck.api.model.repository;

import com.sinoduck.api.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author where.liu
 */
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findFirstByAccessToken(String accessToken);
}
