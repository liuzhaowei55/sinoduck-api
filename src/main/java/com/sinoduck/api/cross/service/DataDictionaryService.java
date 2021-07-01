package com.sinoduck.api.cross.service;

import com.sinoduck.api.cross.exception.DataDictionaryKeyExistsException;
import com.sinoduck.api.db.entity.DataDictionary;

import java.util.Optional;

/**
 * 数据字典操作方法
 *
 * @author where
 */
public interface DataDictionaryService {
    /**
     * 获取数字
     *
     * @param key key
     * @return 字符串
     */
    String getStringValue(String key);

    /**
     * 获取整数
     *
     * @param key key
     * @return 整数
     */
    Integer getIntegerValue(String key);

    /**
     * 获取一个 json 的反序化结果
     *
     * @param key   key
     * @param clazz value 反序列化的结构
     * @return 结果
     */
    <T> T getObjectValue(String key, Class<T> clazz);

    /**
     * 获取字典
     *
     * @param key key
     * @return 字典
     */
    Optional<DataDictionary> get(String key);

    /**
     * 添加记录
     *
     * @param dataDictionary 记录
     * @return 记录
     * @throws DataDictionaryKeyExistsException key 存在时抛出
     */
    DataDictionary add(DataDictionary dataDictionary) throws DataDictionaryKeyExistsException;

    /**
     * 删除记录
     *
     * @param dataDictionary 删除
     */
    void delete(DataDictionary dataDictionary);

    /**
     * 更新
     *
     * @param dataDictionary 记录
     * @return 新的记录
     */
    DataDictionary modify(DataDictionary dataDictionary);
}
