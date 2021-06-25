package com.sinoduck.manage.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @author where.liu
 */
@SpringBootApplication
@ServletComponentScan
@EnableJpaAuditing
public class SinoduckApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinoduckApiApplication.class, args);
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

}
