package com.sinoduck.api.util;

import com.sinoduck.api.pojo.domain.UserDO;

import java.util.Optional;

/**
 * @author where.liu
 */
public class ThreadGlobalInfoContextHolder {
    private static final ThreadLocal<Optional<UserDO>> USER_DO_THREAD_LOCAL = new ThreadLocal<>();

    public static Optional<UserDO> getUser() {
        return USER_DO_THREAD_LOCAL.get();
    }

    public static void setUser(UserDO userDO) {
        USER_DO_THREAD_LOCAL.set(Optional.of(userDO));
    }

    public static void removeUser() {
        USER_DO_THREAD_LOCAL.remove();
    }
}
