package com.sinoduck.db.repository;

import com.sinoduck.db.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author where.liu
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    Optional<User> findFirstByUsername(String username);
}
