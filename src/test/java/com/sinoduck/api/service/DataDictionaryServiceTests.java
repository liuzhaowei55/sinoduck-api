package com.sinoduck.api.service;

import com.sinoduck.api.model.entity.DataDictionary;
import com.sinoduck.api.model.repository.DataDictionaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class DataDictionaryServiceTests {
    @Resource
    private DataDictionaryService dataDictionaryService;

    @Resource
    private DataDictionaryRepository dataDictionaryRepository;

    @Test
    public void testAdd() {
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setName("name");
        dataDictionary.setKey("key");
        dataDictionary.setValue("value");
        dataDictionary.setType(DataDictionary.TypeEnum.STRING.getCode());
        this.dataDictionaryRepository.save(dataDictionary);
        log.info("dataDictionary: {}", dataDictionary);
    }
}
