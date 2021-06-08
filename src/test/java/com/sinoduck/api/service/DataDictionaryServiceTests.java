package com.sinoduck.api.service;

import com.sinoduck.api.model.entity.DataDictionary;
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
        dataDictionary.setKey("value");
        dataDictionary.setType(DataDictionary.TypeEnum.STRING);
        this.dataDictionaryService.add(dataDictionary);
    }
}
