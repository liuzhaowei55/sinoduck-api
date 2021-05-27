package com.sinoduck.api.service;

import cn.hutool.core.util.RandomUtil;
import com.sinoduck.api.model.entity.Token;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.repository.TokenRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author where.liu
 */
@Service
public class UserService {
    @Resource
    private TokenRepository tokenRepository;

    public Token login(User user) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes!=null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Token token = new Token();
        token.setUserId(user.getId());
        token.setAccessToken(RandomUtil.randomString(16));
        token.setUa(request.getHeader("user-agent"));
        token.setIp(StringUtils.defaultString(request.getHeader("X-Forward-For"), request.getHeader("client-ip")));
        this.tokenRepository.save(token);
        return token;
    }

}
