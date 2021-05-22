package com.sinoduck.api.util;

import com.sinoduck.api.model.entity.User;

/**
 * @author where.liu
 */
public class ThreadGlobalInfoContextHolder {
    private static final ThreadLocal<User> USER_DO_THREAD_LOCAL = new ThreadLocal<>();

    public static User getUser() {
        return USER_DO_THREAD_LOCAL.get();
    }

    public static void setUser(User user) {
        USER_DO_THREAD_LOCAL.set(user);
    }

    public static void removeUser() {
        USER_DO_THREAD_LOCAL.remove();
    }
}
