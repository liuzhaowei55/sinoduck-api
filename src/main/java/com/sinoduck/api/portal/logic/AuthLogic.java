package com.sinoduck.api.portal.logic;

import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.mapper.UserMapper;
import com.sinoduck.api.portal.pojo.query.CreateUserQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author where.liu
 */
@Service
public class AuthLogic {
    @Resource
    private UserMapper userMapper;

    public User createUser(CreateUserQuery query) {
        User user = new User();
        user.setUsername(query.getUsername());
        user.setPassword(query.getPassword());
        this.userMapper.insert(user);
        return user;
    }
}
