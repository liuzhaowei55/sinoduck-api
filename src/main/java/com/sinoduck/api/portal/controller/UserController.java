package com.sinoduck.api.portal.controller;

import com.sinoduck.api.exception.ErrorResponseException;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.pojo.dto.ResponseDTO;
import com.sinoduck.api.portal.logic.UserLogic;
import com.sinoduck.api.portal.pojo.converter.UserConverter;
import com.sinoduck.api.portal.pojo.query.DeleteUserQuery;
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
     * 用户账户删除
     *
     * @return 用户删除自己的账户
     */
    @PostMapping(value = "/delete")
    public ResponseDTO delete(@Valid @RequestBody DeleteUserQuery query) {
        return ResponseDTO.success();
    }
}
