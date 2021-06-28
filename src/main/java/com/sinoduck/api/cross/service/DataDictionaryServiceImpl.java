package com.sinoduck.api.cross.service;

import com.alibaba.fastjson.JSON;
import com.sinoduck.api.db.entity.DataDictionary;
import com.sinoduck.api.db.repository.DataDictionaryRepository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author where
 */
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryRepository dataDictionaryRepository;

    @Override
    public Integer getIntegerValue(String key) {
        Optional<DataDictionary> optionalDataDictionary = this.dataDictionaryRepository.findFirstByKey(key);
        if (optionalDataDictionary.isEmpty()) {
            return null;
        }
        DataDictionary dataDictionary = optionalDataDictionary.get();
        return Integer.parseInt(dataDictionary.getValue());
    }

    @Override
    public String getStringValue(String key) {
        Optional<DataDictionary> optionalDataDictionary = this.dataDictionaryRepository.findFirstByKey(key);
        if (optionalDataDictionary.isEmpty()) {
            return null;
        } else {
            return optionalDataDictionary.get().getValue();
        }
    }

    @Override
    public DataDictionary add(DataDictionary dictionary) {
        return this.dataDictionaryRepository.save(dictionary);
    }

    @Override
    public void delete(DataDictionary dictionary) {
        dictionary.setDeletedAt(LocalDateTime.now());
        this.dataDictionaryRepository.save(dictionary);
    }

    @Override
    public DataDictionary modify(DataDictionary dictionary) {
        return this.dataDictionaryRepository.save(dictionary);
    }

    @Override
    public <T> T getObjectValue(String key, Class<T> clazz) {
        Optional<DataDictionary> optionalDataDictionary = this.dataDictionaryRepository.findFirstByKey(key);
        if (optionalDataDictionary.isEmpty()) {
            return null;
        }
        return JSON.parseObject(optionalDataDictionary.get().getValue(), clazz);
    }
}
