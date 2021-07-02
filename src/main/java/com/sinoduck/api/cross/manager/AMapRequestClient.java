package com.sinoduck.api.cross.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author where
 */
@FeignClient(name = "AMapRequestClient", url = "https://restapi.amap.com")
public interface AMapRequestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v5/place/text")
    Object placeText(@RequestParam("key") String key,
                     @RequestParam("keywords") String keywords);
}
