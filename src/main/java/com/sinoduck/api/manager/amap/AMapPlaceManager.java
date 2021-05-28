package com.sinoduck.api.manager.amap;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author where.liu
 * @see https://lbs.amap.com/api/webservice/guide/api/search
 */
@Service
public class AMapPlaceManager {
    @Resource
    private RestTemplate restTemplate;
}
