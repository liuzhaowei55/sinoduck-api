package com.sinoduck.api.manager;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author where.liu
 * @link https://lbs.amap.com/api/webservice/guide/api/search
 */
@Slf4j
@Service
public class AMapManager {

    @Value("${application.manager.amap.web-api-key}")
    private String aMapKey;
    @Resource
    private AMapRequestClient aMapRequestClient;
    @Resource
    private ObjectMapper objectMapper;


    public void searchKeywords() {
        Object object = aMapRequestClient.placeText(aMapKey, "卓悦汇");

        log.info(object.toString());


    }
}
