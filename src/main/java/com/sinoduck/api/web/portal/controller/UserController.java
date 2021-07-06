package com.sinoduck.api.web.portal.controller;

import com.sinoduck.api.web.exception.ErrorResponseException;
import com.sinoduck.api.web.exception.InputException;
import com.sinoduck.api.module.user.db.entity.User;
import com.sinoduck.api.web.dto.ResponseDTO;
import com.sinoduck.api.web.portal.logic.UserLogic;
import com.sinoduck.api.web.portal.pojo.converter.UserConverter;
import com.sinoduck.api.web.portal.pojo.query.ChangePasswordQuery;
import com.sinoduck.api.web.portal.pojo.query.ChangeProfileQuery;
import com.sinoduck.api.web.portal.pojo.query.DeleteUserQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户相关操作
 *
 * @author where.liu
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserLogic userLogic;

    /**
     * 用户基本信息
     *
     * @return 用户信息
     */
    @GetMapping(value = "/profile")
    public ResponseDTO profile() throws ErrorResponseException {
        User user = this.userLogic.profile();
        return ResponseDTO.success(UserConverter.INSTANCE.toUserProfileDTO(user));
    }

    /**
     * 修改用户信息，除头像，密码
     *
     * @return ResponseDTO
     */
    @PostMapping(value = "/profile/change")
    public ResponseDTO changeProfile(@Valid @RequestBody ChangeProfileQuery query) throws ErrorResponseException {
        this.userLogic.changeProfile(query);
        return ResponseDTO.success();
    }

    /**
     * 修改密码
     *
     * @return ResponseDTO
     */
    @PostMapping(value = "/password/change")
    public ResponseDTO changePassword(@Valid @RequestBody ChangePasswordQuery query) throws InputException, ErrorResponseException {
        this.userLogic.changePassword(query);
        return ResponseDTO.success();
    }

    /**
     * 用户账户删除
     *
     * @return 用户删除自己的账户
     */
    @PostMapping(value = "/delete")
    public ResponseDTO delete(@Valid @RequestBody DeleteUserQuery query) throws InputException, ErrorResponseException {
        this.userLogic.delete(query);
        return ResponseDTO.success();
    }
}
