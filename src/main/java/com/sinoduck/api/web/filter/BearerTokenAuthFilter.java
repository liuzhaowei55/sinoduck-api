package com.sinoduck.api.web.filter;

import com.sinoduck.api.module.user.db.entity.User;
import com.sinoduck.api.module.user.db.entity.UserToken;
import com.sinoduck.api.module.user.db.repository.UserRepository;
import com.sinoduck.api.module.user.db.repository.UserTokenRepository;
import com.sinoduck.api.web.util.ThreadGlobalInfoContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * @author where.liu
 */
@WebFilter(filterName = "bearerTokenAuthFilter", urlPatterns = "/*")
@Slf4j
public class BearerTokenAuthFilter implements Filter {
    private final static String BEARER_TOKEN_PREFIX = "Bearer ";

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserTokenRepository userTokenRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String authorization = httpServletRequest.getHeader("Authorization");
        if (StringUtils.isNotEmpty(authorization) && authorization.startsWith(BEARER_TOKEN_PREFIX)) {
            String accessToken = authorization.substring(7);
            Optional<UserToken> optionalToken = userTokenRepository.findFirstByAccessToken(accessToken);
            optionalToken.ifPresent(token -> {
                ThreadGlobalInfoContextHolder.setToken(token);
                Optional<User> optionalUser = userRepository.findById(token.getUserId());
                optionalUser.ifPresent(ThreadGlobalInfoContextHolder::setUser);
            });

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
