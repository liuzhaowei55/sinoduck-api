package com.sinoduck.api.filter;

import com.sinoduck.api.pojo.domain.UserDO;
import com.sinoduck.api.util.ThreadGlobalInfoContextHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author where.liu
 */
@WebFilter(filterName = "bearerTokenAuthFilter", urlPatterns = "/*")
@Slf4j
public class BearerTokenAuthFilter implements Filter {
    private final static String BEARER_TOKEN_PREFIX = "Bearer ";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String authorization = httpServletRequest.getHeader("Authorization");
        if (authorization.startsWith(BEARER_TOKEN_PREFIX)) {
            UserDO userDO = new UserDO();
            userDO.setId(1L);
            ThreadGlobalInfoContextHolder.setUser(userDO);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
