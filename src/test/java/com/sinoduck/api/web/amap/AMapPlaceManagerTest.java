package com.sinoduck.api.web.amap;

import com.sinoduck.api.manager.AMapManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class AMapPlaceManagerTest {
    @Resource
    private AMapManager aMapManager;

    @Test
    public void testSearchKeywords() {
        this.aMapManager.searchKeywords();
    }
}
