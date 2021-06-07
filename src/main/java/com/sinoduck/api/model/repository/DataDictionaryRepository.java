package com.sinoduck.api.model.repository;

import com.sinoduck.api.model.entity.DataDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author where.liu
 */
@Repository
public interface DataDictionaryRepository extends JpaRepository<DataDictionary, Long> {
    /**
     * 根据字典名称模糊查找
     *
     * @param name 名称
     * @return 列表
     */
    @Query("select t from DataDictionary as t where t.name like '%:name%'")
    List<DataDictionary> findAllByNameLike(@Param("name") String name);

    /**
     * 根据字典 key 查找
     *
     * @param key key
     * @return row
     */
    DataDictionary findFirstByKey(String key);
}
