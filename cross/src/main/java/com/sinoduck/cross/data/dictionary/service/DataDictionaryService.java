package com.sinoduck.cross.data.dictionary.service;

import com.sinoduck.api.model.entity.DataDictionary;

/**
 * 数据字典操作方法
 *
 * @author where
 */
public interface DataDictionaryService {
    /**
     * 获取整数
     *
     * @param key key
     * @return 整数
     */
    Integer getIntegerValue(String key);

    /**
     * 获取数字
     *
     * @param key key
     * @return 字符串
     */
    String getStringValue(String key);

    /**
     * 添加记录
     *
     * @param dictionary 记录
     * @return 记录
     */
    DataDictionary add(DataDictionary dictionary);

    /**
     * 删除记录
     *
     * @param dictionary 删除
     */
    void delete(DataDictionary dictionary);

    /**
     * 更新
     *
     * @param dictionary 记录
     * @return 新的记录
     */
    DataDictionary modify(DataDictionary dictionary);

    /**
     * 获取一个 json 的反序化结果
     *
     * @param key   key
     * @param clazz value 反序列化的结构
     * @return 结果
     */
    <T> T getStructData(String key, Class<T> clazz);
}
