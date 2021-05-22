package com.sinoduck.api.filter;

import com.sinoduck.api.model.entity.User;
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
            User user = new User();
            user.setId(1L);
            ThreadGlobalInfoContextHolder.setUser(user);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
