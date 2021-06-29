package com.sinoduck.api.cross.service;

import cn.hutool.core.lang.Assert;
import com.sinoduck.api.db.entity.DataDictionary;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class DataDictionaryServiceTests {
    @Resource
    private DataDictionaryService dataDictionaryService;

    @Test
    public void testAdd() {
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setName("name");
        dataDictionary.setKey("key");
        dataDictionary.setValue("value");
        dataDictionary.setType(DataDictionary.TypeEnum.STRING.getCode());
        dataDictionary = this.dataDictionaryService.add(dataDictionary);
        log.info("dataDictionary: {}", dataDictionary);
        Assert.isTrue(dataDictionary.getId() >= 1L);
    }
}
