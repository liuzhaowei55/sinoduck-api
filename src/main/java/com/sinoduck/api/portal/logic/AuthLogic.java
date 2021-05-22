package com.sinoduck.api.portal.logic;

import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.repository.UserRepository;
import com.sinoduck.api.portal.pojo.query.CreateUserQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author where.liu
 */
@Service
public class AuthLogic {
    @Resource
    private UserRepository userRepository;

    public User createUser(CreateUserQuery query) {
        User user = new User();
        user.setUsername(query.getUsername());
        user.setPassword(query.getPassword());
        this.userRepository.save(user);
        return user;
    }
}
