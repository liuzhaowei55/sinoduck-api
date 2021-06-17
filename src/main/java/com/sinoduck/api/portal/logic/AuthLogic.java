package com.sinoduck.api.portal.logic;

import com.sinoduck.api.exception.CustomErrorEnum;
import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.exception.InputException;
import com.sinoduck.api.model.entity.UserToken;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.repository.UserTokenRepository;
import com.sinoduck.api.model.repository.UserRepository;
import com.sinoduck.api.portal.pojo.query.CreateUserQuery;
import com.sinoduck.api.service.UserPasswordService;
import com.sinoduck.api.service.UserService;
import com.sinoduck.api.util.ThreadGlobalInfoContextHolder;
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
    private UserTokenRepository userTokenRepository;
    @Resource
    private UserService userService;
    @Resource
    private UserPasswordService userPasswordService;

    public User createUser(CreateUserQuery query) {
        User user = new User();
        user.setUsername(query.getUsername());
        this.userRepository.save(user);
        this.userPasswordService.addPassword(user, query.getPassword());
        return user;
    }

    public UserToken login(String username, String password) throws InputException {
        Optional<User> optionalUser = userRepository.findFirstByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new InputException("username", "用户不存在");
        }
        if (this.userPasswordService.passwordIsInvalid(optionalUser.get(), password)) {
            throw new InputException("password", "密码错误");
        }

        return userService.login(optionalUser.get());
    }

    public void logout() throws ErrorResponseException {
        UserToken token = ThreadGlobalInfoContextHolder.getToken();
        if (null==token) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        this.userTokenRepository.delete(token);
    }
}
