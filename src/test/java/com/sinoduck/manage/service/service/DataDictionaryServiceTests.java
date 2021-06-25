package com.sinoduck.manage.service.service;

import com.sinoduck.db.entity.DataDictionary;
import com.sinoduck.db.repository.DataDictionaryRepository;
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
