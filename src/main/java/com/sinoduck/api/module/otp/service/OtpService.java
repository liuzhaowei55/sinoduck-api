package com.sinoduck.api.module.otp.service;

import cn.hutool.crypto.digest.otp.TOTP;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class OtpService {
    private final Integer randomStrLength = 32;

    public String generateSecretKey() {
        return RandomStringUtils.random(16, "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
    }

    public Integer generateToken(String key) {
        TOTP totp = new TOTP(key.getBytes(StandardCharsets.UTF_8));
        return totp.generate(6);
    }
}
