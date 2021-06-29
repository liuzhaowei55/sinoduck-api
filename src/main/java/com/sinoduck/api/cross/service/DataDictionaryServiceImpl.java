package com.sinoduck.api.cross.service;

import com.alibaba.fastjson.JSON;
import com.sinoduck.api.db.entity.DataDictionary;
import com.sinoduck.api.db.repository.DataDictionaryRepository;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author where
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryRepository dataDictionaryRepository;

    @Resource
    private RedissonClient redissonClient;

    private final static Integer LOCK_SECONDS = 5;
    private final static Integer LOCK_WAIT_SECONDS = 5;

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
    public DataDictionary add(DataDictionary dataDictionary) {
        RLock rLock = redissonClient.getLock(this.getRedisLockKey(dataDictionary.getKey()));
        try {
            if (rLock.tryLock(LOCK_WAIT_SECONDS, LOCK_SECONDS, TimeUnit.SECONDS)) {
                Boolean isExists = this.dataDictionaryRepository.existsByKey(dataDictionary.getKey());
                if (isExists) {
                    return null;
                }
                return this.dataDictionaryRepository.save(dataDictionary);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
        return null;
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

    @Override
    public DataDictionary get(String key) {
        DataDictionary dataDictionary = null;
        RBucket<DataDictionary> rBucket = redissonClient.getBucket(this.getRedisCacheKey(key));
        if (rBucket.isExists()) {
            dataDictionary = rBucket.get();
        } else {
            Optional<DataDictionary> optionalDataDictionary = this.dataDictionaryRepository.findFirstByKey(key);
            if (optionalDataDictionary.isPresent()) {
                rBucket.set(optionalDataDictionary.get(), 5, TimeUnit.MINUTES);
                dataDictionary = optionalDataDictionary.get();
            }
        }
        return dataDictionary;
    }

    private String getRedisLockKey(String key) {
        return "data_dictionary:lock:key:" + key;
    }

    private String getRedisCacheKey(String key) {
        return "data_dictionary:cache:key:" + key;
    }
}
