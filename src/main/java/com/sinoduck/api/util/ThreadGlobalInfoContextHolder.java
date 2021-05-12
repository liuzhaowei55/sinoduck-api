package com.sinoduck.api.util;

import com.sinoduck.api.pojo.domain.UserDO;

import java.util.Optional;

/**
 * @author where.liu
 */
public class ThreadGlobalInfoContextHolder {
    private static final ThreadLocal<UserDO> USER_DO_THREAD_LOCAL = new ThreadLocal<>();

    public static UserDO getUser() {
        return USER_DO_THREAD_LOCAL.get();
    }

    public static void setUser(UserDO userDO) {
        USER_DO_THREAD_LOCAL.set(userDO);
    }

    public static void removeUser() {
        USER_DO_THREAD_LOCAL.remove();
    }
}
