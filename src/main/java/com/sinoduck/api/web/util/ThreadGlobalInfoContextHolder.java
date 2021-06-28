package com.sinoduck.api.web.util;

import com.sinoduck.api.db.entity.UserToken;
import com.sinoduck.api.db.entity.User;

/**
 * @author where.liu
 */
public class ThreadGlobalInfoContextHolder {
    private static final ThreadLocal<User> USER_DO_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<UserToken> TOKEN_DO_THREAD_LOCAL = new ThreadLocal<>();

    public static User getUser() {
        return USER_DO_THREAD_LOCAL.get();
    }

    public static void setUser(User user) {
        USER_DO_THREAD_LOCAL.set(user);
    }

    public static void removeUser() {
        USER_DO_THREAD_LOCAL.remove();
    }

    public static UserToken getToken() {
        return TOKEN_DO_THREAD_LOCAL.get();
    }

    public static void setToken(UserToken token) {
        TOKEN_DO_THREAD_LOCAL.set(token);
    }

    public static void removeToken() {
        TOKEN_DO_THREAD_LOCAL.remove();
    }


}
