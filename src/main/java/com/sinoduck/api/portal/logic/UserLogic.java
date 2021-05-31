package com.sinoduck.api.portal.logic;

import com.sinoduck.api.exception.CustomErrorEnum;
import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.exception.InputException;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.portal.pojo.query.DeleteUserQuery;
import com.sinoduck.api.service.FolderService;
import com.sinoduck.api.util.ThreadGlobalInfoContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author where.liu
 */
@Service
public class UserLogic {
    @Resource
    private FolderService folderService;

    public User profile() throws ErrorResponseException {
        User user = ThreadGlobalInfoContextHolder.getUser();
        if (null==user) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        return user;
    }

    public void delete(DeleteUserQuery query) throws ErrorResponseException, InputException {
        User user = ThreadGlobalInfoContextHolder.getUser();
        if (null==user) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        if (!user.checkPassword(query.getPassword())) {
            throw new InputException("password", "密码错误");
        }
        // 删除所有的文件夹
        this.folderService.delete(user);
    }
}
