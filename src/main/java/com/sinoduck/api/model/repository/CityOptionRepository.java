package com.sinoduck.api.model.repository;

import com.sinoduck.api.model.entity.CityOption;
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
public interface CityOptionRepository extends JpaRepository<CityOption, Long> {
    Optional<CityOption> findFirstByCode(String code);

    /**
     * 根据名称模糊查找
     *
     * @param name 模糊查找的名称
     * @return 城市信息列表
     */
    @Query(value = "select t from CityOption t where t.name like %:name%")
    List<CityOption> findAllByNameLike(@Param("name") String name);

    /**
     * 查出省
     *
     * @return 省列表
     */
    @Query(value = "select t from CityOption t where LENGTH(t.code) = 2")
    List<CityOption> listProvince();

}
