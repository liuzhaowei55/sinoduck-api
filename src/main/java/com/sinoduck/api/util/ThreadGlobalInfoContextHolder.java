package com.sinoduck.api.util;

import com.sinoduck.api.dao.domain.UserDo;

/**
 * @author where.liu
 */
public class ThreadGlobalInfoContextHolder {
    private static final ThreadLocal<UserDo> USER_DO_THREAD_LOCAL = new ThreadLocal<>();

    public static UserDo getUser() {
        return USER_DO_THREAD_LOCAL.get();
    }

    public static void setUser(UserDo userDO) {
        USER_DO_THREAD_LOCAL.set(userDO);
    }

    public static void removeUser() {
        USER_DO_THREAD_LOCAL.remove();
    }
}
