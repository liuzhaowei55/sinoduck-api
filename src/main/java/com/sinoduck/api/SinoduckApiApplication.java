package com.sinoduck.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author where.liu
 */
@SpringBootApplication
@ServletComponentScan
public class SinoduckApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinoduckApiApplication.class, args);
    }

}
