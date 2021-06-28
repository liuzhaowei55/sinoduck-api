package com.sinoduck.manage.service.service;

import cn.hutool.core.util.RandomUtil;
import com.sinoduck.api.db.entity.User;
import com.sinoduck.api.db.entity.UserPassword;
import com.sinoduck.api.db.entity.UserToken;
import com.sinoduck.api.db.repository.UserPasswordRepository;
import com.sinoduck.api.db.repository.UserRepository;
import com.sinoduck.api.db.repository.UserTokenRepository;
import com.sinoduck.manage.service.portal.pojo.query.CreateUserQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author where.liu
 */
@Service
public class UserService {
    @Resource
    private UserTokenRepository userTokenRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserPasswordRepository userPasswordRepository;

    public UserToken login(User user) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes!=null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Optional<UserPassword> optionalUserPassword = this.userPasswordRepository.findFirstByUserIdAndDeletedAtNullOrderByIdDesc(user.getId());
        UserToken token = new UserToken();
        token.setUserId(user.getId());
        optionalUserPassword.ifPresent(tmp -> token.setUserPasswordId(tmp.getId()));
        token.setAccessToken(RandomUtil.randomString(16));
        token.setUa(request.getHeader("user-agent"));
        token.setIp(StringUtils.defaultString(request.getHeader("X-Forward-For"), request.getRemoteAddr()));
        this.userTokenRepository.save(token);
        return token;
    }

    public User create(CreateUserQuery query) {
        User user = new User();
        user.setUsername(query.getUsername());
        this.userRepository.save(user);
        return user;
    }

}
