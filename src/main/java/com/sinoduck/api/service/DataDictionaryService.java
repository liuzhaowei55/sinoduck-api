package com.sinoduck.api.service;

import com.sinoduck.api.model.entity.DataDictionary;
import com.sinoduck.api.model.repository.DataDictionaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author where.liu
 */
@Service
@Slf4j
public class DataDictionaryService {
    @Resource
    private DataDictionaryRepository dataDictionaryRepository;

    @Resource
    private RedissonClient redissonClient;

    private final static Integer LOCK_SECONDS = 5;
    private final static Integer LOCK_WAIT_SECONDS = 5;

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

    public DataDictionary get(@NotNull String key) {
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
