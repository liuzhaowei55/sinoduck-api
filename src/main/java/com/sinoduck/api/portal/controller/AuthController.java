package com.sinoduck.api.portal.controller;

import com.sinoduck.api.exception.InputException;
import com.sinoduck.api.model.entity.User;
import com.sinoduck.api.pojo.dto.ResponseDTO;
import com.sinoduck.api.portal.logic.AuthLogic;
import com.sinoduck.api.portal.pojo.query.CreateUserQuery;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author where.liu
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Resource
    private AuthLogic authLogic;

    /**
     * 注册
     *
     * @return 注册结果
     */
    @PostMapping(value = "/register")
    public ResponseDTO register(@Valid @RequestBody CreateUserQuery query) throws InputException {
        if (!query.getPassword().equals(query.getPasswordConfirmation())) {
            throw new InputException("password", "密码和确认密码需要一致");
        }
        User user = authLogic.createUser(query);
        return ResponseDTO.success(user);
    }

    @PostMapping(value = "/login")
    public ResponseDTO login() {
        return ResponseDTO.success();
    }
}
