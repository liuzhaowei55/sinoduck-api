package com.sinoduck.manage.service.service;

import cn.hutool.crypto.digest.BCrypt;
import com.sinoduck.api.db.entity.User;
import com.sinoduck.api.db.entity.UserPassword;
import com.sinoduck.api.db.repository.UserPasswordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author where.liu
 */
@Service
@Slf4j
public class UserPasswordService {
    @Resource
    private UserPasswordRepository userPasswordRepository;

    public void setPassword(User user, String password) {
        Optional<UserPassword> optionalUserPassword =
                this.userPasswordRepository.findFirstByUserIdAndDeletedAtNullOrderByIdDesc(user.getId());
        optionalUserPassword.ifPresent(tmp -> this.userPasswordRepository.softDelete(tmp));
        this.addPassword(user, password);
    }

    public void addPassword(User user, String password) {
        UserPassword userPassword = new UserPassword();
        userPassword.setUserId(user.getId());
        userPassword.setPassword(password);
        this.userPasswordRepository.save(userPassword);
    }

    public Boolean passwordIsInvalid(User user, String password) {
        return !this.passwordIsValid(user, password);
    }

    public Boolean passwordIsValid(User user, String password) {
        Optional<UserPassword> optionalUserPassword =
                this.userPasswordRepository.findFirstByUserIdAndDeletedAtNullOrderByIdDesc(user.getId());
        if (optionalUserPassword.isEmpty()) {
            log.error("用户不存在有效的密码记录，user_id: {}", user.getId());
            return false;
        }
        return BCrypt.checkpw(password, optionalUserPassword.get().getPassword());
    }
}
