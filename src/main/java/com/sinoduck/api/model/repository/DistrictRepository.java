package com.sinoduck.api.model.repository;

import com.sinoduck.api.model.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author where.liu
 */
@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    Optional<District> findFirstByCode(String code);

    /**
     * 根据名称模糊查找
     *
     * @param name 模糊查找的名称
     * @return 城市信息列表
     */
    @Query(value = "select t from District t where t.name like %:name%")
    List<District> findAllByNameLike(@Param("name") String name);

    /**
     * 查出省
     *
     * @return 省列表
     */
    @Query(value = "select t from District t where LENGTH(t.code) = 2")
    List<District> listProvince();

}
