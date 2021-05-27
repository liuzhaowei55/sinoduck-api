package com.sinoduck.api.portal.logic;

import com.sinoduck.api.exception.InputException;
import com.sinoduck.api.model.entity.Token;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.repository.TokenRepository;
import com.sinoduck.api.model.repository.UserRepository;
import com.sinoduck.api.portal.pojo.query.CreateUserQuery;
import com.sinoduck.api.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author where.liu
 */
@Service
public class AuthLogic {
    @Resource
    private UserRepository userRepository;
    @Resource
    private TokenRepository tokenRepository;
    @Resource
    private UserService userService;

    public User createUser(CreateUserQuery query) {
        User user = new User();
        user.setUsername(query.getUsername());
        user.setPassword(query.getPassword());
        this.userRepository.save(user);
        return user;
    }

    public Token login(String username, String password) throws InputException {
        Optional<User> optionalUser = userRepository.findFirstByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new InputException("username", "用户不存在");
        }
        if (!optionalUser.get().checkPassword(password)) {
            throw new InputException("password", "密码错误");
        }
        return userService.login(optionalUser.get());
    }
}
