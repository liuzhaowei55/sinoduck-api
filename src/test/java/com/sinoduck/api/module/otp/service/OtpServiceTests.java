package com.sinoduck.api.module.otp.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class OtpServiceTests {
    @Resource
    private OtpService otpService;

    @Test
    public void testGenerateSecretKey() {
        log.info(otpService.generateSecretKey());
    }

    @Test
    public void testGenerateToken() {
        String key = otpService.generateSecretKey();
        log.info(key);
        Integer token = otpService.generateToken(key);
        log.info(token + "");
    }
}
