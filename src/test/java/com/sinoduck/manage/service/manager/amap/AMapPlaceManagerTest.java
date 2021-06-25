package com.sinoduck.manage.service.manager.amap;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class AMapPlaceManagerTest {
    @Resource
    private AMapPlaceManager aMapPlaceManager;

    @Test
    public void testSearchKeywords() {
        this.aMapPlaceManager.searchKeywords();
    }
}
