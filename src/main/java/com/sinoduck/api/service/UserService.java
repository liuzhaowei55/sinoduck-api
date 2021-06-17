package com.sinoduck.api.service;

import cn.hutool.core.util.RandomUtil;
import com.sinoduck.api.model.entity.UserPassword;
import com.sinoduck.api.model.entity.UserToken;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.repository.UserPasswordRepository;
import com.sinoduck.api.model.repository.UserTokenRepository;
import com.sinoduck.api.model.repository.UserRepository;
import com.sinoduck.api.portal.pojo.query.CreateUserQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
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
