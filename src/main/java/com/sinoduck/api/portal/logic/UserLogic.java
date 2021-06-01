package com.sinoduck.api.portal.logic;

import com.sinoduck.api.exception.CustomErrorEnum;
import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.exception.InputException;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.model.repository.UserRepository;
import com.sinoduck.api.portal.pojo.query.ChangePasswordQuery;
import com.sinoduck.api.portal.pojo.query.ChangeProfileQuery;
import com.sinoduck.api.portal.pojo.query.DeleteUserQuery;
import com.sinoduck.api.service.FolderService;
import com.sinoduck.api.util.ThreadGlobalInfoContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author where.liu
 */
@Service
public class UserLogic {
    @Resource
    private FolderService folderService;
    @Resource
    private UserRepository userRepository;

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

    public void changePassword(ChangePasswordQuery query) throws ErrorResponseException, InputException {
        User user = ThreadGlobalInfoContextHolder.getUser();
        if (null==user) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        // 校验旧密码是否正确
        if (!user.checkPassword(query.getOldPassword())) {
            throw new InputException("oldPassword", "密码错误");
        }
        // 校验新密码和确认密码是否相等
        if (!query.getNewPasswordConfirmation().equals(query.getNewPassword())) {
            throw new InputException("newPasswordConfirmation", "确认密码与新密码不一致");
        }
        user.setPassword(query.getNewPassword());
        this.userRepository.save(user);
    }

    public User changeProfile(ChangeProfileQuery query) throws ErrorResponseException {
        User user = ThreadGlobalInfoContextHolder.getUser();
        if (null==user) {
            throw new ErrorResponseException(CustomErrorEnum.CURRENT_USER_NOT_FOUND);
        }
        if (StringUtils.isNoneBlank(query.getNickname())) {
            user.setNickname(query.getNickname());
        }
        userRepository.save(user);
        return user;
    }
}
