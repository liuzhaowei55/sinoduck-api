package com.sinoduck.api.manager.amap;


import cn.hutool.core.net.URLDecoder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author where.liu
 * @link https://lbs.amap.com/api/webservice/guide/api/search
 */
@Slf4j
@Service
public class AMapPlaceManager {
    private final OkHttpClient client;

    public AMapPlaceManager() {
        this.client = new OkHttpClient();
    }

    public void searchKeywords() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("restapi.amap.com")
                .encodedPath("/v3/place/text")
                .addQueryParameter("key", "36e319da51cce650b847faa4cfd47e5d")
                .addQueryParameter("keywords", "卓悦汇")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        log.error("url: {}", url.uri());
        try {
            Response response = client.newCall(request).execute();
            log.error("resp: {}", response.body().string());
        } catch (IOException e) {
            log.error(": {}", e);
        }


    }
}
