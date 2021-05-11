package com.sinoduck.api.controller;

import com.sinoduck.api.pojo.dto.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author where.liu
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {
    @RequestMapping()
    public ResponseDTO index() {
        return ResponseDTO.success("Hello");
    }
}
